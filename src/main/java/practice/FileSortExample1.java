package practice;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileSortExample1 {

    public static void main(String[] args) {

        File[] files = new File("C:\\Program Files\\Java\\jdk1.8.0_221").listFiles();

        Comparator<File> fileComparator = (file1, file2) -> {

            System.out.println(file1.compareTo(file2));
            return file1.compareTo(file2);
        };

        assert files != null;
        Arrays.sort(files, fileComparator);

        for (File file : files){

            if (!file.isHidden() && file.isDirectory())

                    System.out.println("DIR \t \t : " + file.getName());
            else
                System.out.println("FILE \t \t : " + file.getName());
        }
    }
}
