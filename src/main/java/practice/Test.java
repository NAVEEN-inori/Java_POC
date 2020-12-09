package practice;

import java.lang.*;
import java.util.*;

@SuppressWarnings("all")
public class Test {

    public static void main(String[] args) {

        if (HelperClass.areAnagram("adcbef", "badcfe")){

            System.out.println("The two strings are " +
                    "anagram of each other");
        } else {

            System.out.println("The two strings are " +
                    "not anagram of each other");
        }
    }
}

class HelperClass{

    static boolean areAnagram(String s1, String s2){

        char[] charArrayOfS1 = s1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] charArrayOfS2 = s2.replaceAll("\\s", "").toLowerCase().toCharArray();

        if (charArrayOfS1.length != charArrayOfS2.length)
            return false;

        Arrays.sort(charArrayOfS1);
        Arrays.sort(charArrayOfS2);

        for (int i=0; i < charArrayOfS1.length; i++){
            if (charArrayOfS1[i] != charArrayOfS2[i]){
                return false;
            }
        }

        return true;
    }
}