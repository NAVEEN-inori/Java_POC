package practice;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileSortExample2 {

    public static void main(String[] args) {

        File[] files = new File("C:\\Program Files\\Java\\jdk1.8.0_221").listFiles();

        assert files != null;
        Comparator<File> fileComparator = (file1, file2) -> {

            if (file1.isDirectory() && !file2.isDirectory()) {

                return -1;
            } else if (!file1.isDirectory() && file2.isDirectory()) {

                return 1;
            } else {

                return file1.compareTo(file2);
            }
        };

        Arrays.sort(files, fileComparator);

        for (File file : files){

            if (!file.isHidden()) {
                if (file.isDirectory()) {
                    System.out.println("DIR \t" + file.getName());
                } else {
                    System.out.println("FILE\t" + file.getName());
                }
            }
        }
    }
}
