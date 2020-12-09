package practice;

public class Simple {

    public static void main(String[] args) {

        String name = "naveen,vijay".toLowerCase();

        String name1 = "Vijay".toLowerCase();

        String[] split = name.split(",");

        for (String param : split){

            if (param.startsWith(name1)){

                System.out.println(param);
            }
        }
    }
}
