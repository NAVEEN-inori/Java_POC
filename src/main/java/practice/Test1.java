package practice;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.apache.commons.lang.ArrayUtils;

import java.io.File;
import java.util.*;

public class Test1 {

    public static void main(String[] args) {

        final String jobInputs = args[0];
        final Map<String, String> applicationArguments;

        if (ArrayUtils.isNotEmpty(args)) {
            Map<String, String> map = new HashMap<>();

            for (String applicationArgument : jobInputs.split(";")) {
                if (map.put(applicationArgument.split("=")[0], applicationArgument.split("=")[1]) != null) {
                    throw new IllegalStateException("Duplicate key");
                }
            }
            applicationArguments = map;
        } else {
            throw new IllegalArgumentException("Input received from batch application is empty");
        }

        Table<String, String, String> table = execute(applicationArguments);
    }

    private static Table<String, String, String> execute(Map<String, String> applicationArguments) {
        String directoryPath = applicationArguments.get("dq-template");
        File[] files = new File(directoryPath).listFiles();
        String[] split = applicationArguments.get("dq-template").split("\\\\");
        String name = split[split.length - 1];

        Table<String, String, String> table = HashBasedTable.create();
        Map<String, List<String>>  map = new HashMap<>();
        List<String> serviceNamesList = new ArrayList<>();

        assert files != null;
        showFiles(files, name, map, serviceNamesList);
        serviceNamesList.add(name);

        String includeParam = (applicationArguments.get("include") != null) ?applicationArguments.get("include") : "";
        String excludeParam = (applicationArguments.get("exclude") != null) ?applicationArguments.get("exclude") : "";

        List<String> includeList = Arrays.asList(includeParam.split(","));
        List<String> excludeList = Arrays.asList(excludeParam.split(","));

        checkDuplicates(includeList, "Include");
        checkDuplicates(excludeList, "exclude");
        validateIncludeExcludeParams(serviceNamesList,includeList,excludeList);

        Map<String, List<String>> includeMap = new HashMap<>();
        Map<String, List<String>> excludeMap = new HashMap<>();
        Map<String, List<String>> finalMap = new HashMap<>();

        checkParam(serviceNamesList, includeList);
        checkParam(serviceNamesList, excludeList);

        getMap(serviceNamesList, includeList, includeMap,map);
        getMap(serviceNamesList, excludeList, excludeMap,map);

        List<String> rootLevelFiles = getRootLevelFiles(files, name);

        map.put(name, rootLevelFiles);
        getFinalMap(map, serviceNamesList, includeMap, excludeMap, finalMap);

        putFilesIntoTable(files, name, finalMap, table);

        return table;
    }

    private static void validateIncludeExcludeParams(List<String> serviceNamesList, List<String> includeList, List<String> excludeList) {

        for (String name : serviceNamesList){
            int count1 = 0;
            int count2 = 0;
            for (String param1 : includeList){
                if (param1.startsWith(name))
                    count1++;
            }
            for (String param2 : excludeList){
                if (param2.startsWith(name))
                    count2++;
            }
            if (count1 != 0 && count2 != 0){
                throw new IllegalArgumentException("Same service name should not be pesent in Include" +
                        " and Exclude params : " + name);
            }
        }
    }

    private static void checkDuplicates(List<String> inputList, String name) {

        for (String param : inputList) {
            if (Collections.frequency(inputList, param) > 1){

                System.out.println("Given " + name + " param inputs are : " + inputList);
                throw new IllegalArgumentException("duplicate key : " + param);
            }
        }
    }

    private static List<String> getRootLevelFiles(File[] files, String name)
    {
        List<String> list = new ArrayList<>();

        for (File file : files){
            if (!file.isDirectory())
            {

                String fileName = file.getName().split("\\.")[0];
                list.add(name + "." + fileName);
            }
        }
        return list;
    }

    private static void checkParam(List<String> serviceNamesList, List<String> includeList) {
        if (includeList.size() > 0 && !includeList.contains("")) {
            for (String param : serviceNamesList) {
                List<String> list = new ArrayList<>();

                for (String param1 : includeList) {
                    if (param1.trim().startsWith(param))
                        list.add(param1);
                }
                if (list.size() > 1 && list.contains(param))
                    throw new IllegalArgumentException("Incorrect service name specification : " + list);
            }
        }
    }

    private static void putFilesIntoTable(File[] files, String name, Map<String, List<String>> finalMap,
                                          Table<String, String, String> table) {
        for (File file : files){
            if (file.isDirectory())
            {
                String fileName = file.getName();
                File[] files1 = file.listFiles();

                assert files1 != null;
                putFilesIntoTable(files1, fileName, finalMap, table);
            } else
                {
                String splitName = file.getName().split("\\.")[0];
                String paramName = name + "." + splitName;
                String filePath = file.getAbsolutePath();
                List<String> list = finalMap.get(name);

                if (list.size() > 0) {
                    if (list.contains(paramName)) {
                        table.put(name, splitName, filePath);
                    }
                }
            }
        }
    }

    private static void getFinalMap(Map<String, List<String>> map, List<String> serviceNamesList, Map<String, List<String>> includeMap, Map<String, List<String>> excludeMap, Map<String, List<String>> finalMap) {
        for (String serviceName : serviceNamesList){

            List<String> list1 = map.get(serviceName);
            List<String> list2 = includeMap.get(serviceName);
            List<String> list3 = excludeMap.get(serviceName);
            List<String> filteredList = new ArrayList<>();

            if (!list2.isEmpty()) {
                for (String param : list2) {
                    if (list1.contains(param)){
                        filteredList.add(param);
                    } else {
                        throw new IllegalArgumentException("Include parameter " +
                                "operation : " + param + " not present in the service : " + serviceName);
                    }
                }
            } else if (!list3.isEmpty()){
                for (String param : list1){
                    if (!list3.contains(param))
                        filteredList.add(param);
                }
            }
            else {
                filteredList = list1;
            }
            finalMap.put(serviceName, filteredList);
        }
    }

    private static void getMap(List<String> serviceNamesList, List<String> list, Map<String, List<String>> outputMap
            , Map<String, List<String>> inputMap) {

        for (String value : list){
            String splitValue = value.split("\\.")[0];

            if ((!serviceNamesList.contains(splitValue)) && (!splitValue.equals(""))){
                System.out.println("Available services are : " + serviceNamesList);
                throw new IllegalArgumentException("service is not part of avaible services : " + splitValue);
            }
        }
        for (String serviceName : serviceNamesList) {
            List<String> includeList = new ArrayList<>();

            for (String param : list) {
                if (param.startsWith(serviceName)) {
                    if (param.trim().equalsIgnoreCase(serviceName.trim())){
                        includeList = inputMap.get(serviceName);
                    } else {
                        includeList.add(param);
                    }
                }
            }
            outputMap.put(serviceName, includeList);
        }
    }

    private static void showFiles(File[] files, String name, Map<String, List<String>> map, List<String> list) {

        for (File file : files){

            if (file.isDirectory()){
                list.add(file.getName());
                File[] files1 = file.listFiles();
                String fileName = file.getName();
                List<String> list1 = new ArrayList<>();

                assert files1 != null;
                for (File file1 : files1) {
                    if (file1.getName().endsWith(".xlsx")) {
                        String s = file1.getName().split("\\.")[0];
                        String s1 = file.getName() + "." + s;
                        list1.add(s1);
                    }
                }
                map.put(fileName,list1);
                showFiles(files1, fileName, map, list);
            }
        }
    }
}