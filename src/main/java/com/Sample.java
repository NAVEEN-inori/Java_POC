package com;

import com.google.gson.Gson;

public class Sample {

    public static void main(String[] args) {

        Pojo nestedPojo;

        nestedPojo = getNestedPojoObject();

        System.out.println(nestedPojo);

    }

    public static Pojo getNestedPojoObject(){

        String nestedJsonPojo = "{\"Id\" : \"10\",\"nestedPojos\":[{\"name\" : Rahul, \"value\" : \"42\"},{\"name\" : Naveen, \"value\" : \"24\"}]}";

        Gson gson = new Gson();

        return gson.fromJson(nestedJsonPojo,Pojo.class);
    }
}
