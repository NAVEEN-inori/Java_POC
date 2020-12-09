package com;

import org.codehaus.jackson.map.ObjectMapper;

public class JacksonArrayExample {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        String Person_Details_Json = "[{\"name\":\"mkyong\", \"age\":37}, {\"name\":\"fong\", \"age\":38}]";

        try{

            Person[] people = objectMapper.readValue(Person_Details_Json,Person[].class);

            System.out.println("Jason Array to Java Array Objects");
            for ( Person person : people ){

                System.out.println(person);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
