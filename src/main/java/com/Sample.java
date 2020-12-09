package com;

import com.google.gson.Gson;

public class Sample {

    public static void main(String[] args) {

        Pojo nestedPojo = new Pojo();

        nestedPojo = getNestedPojoObject();

        System.out.println(nestedPojo);

    }

    public static Pojo getNestedPojoObject(){

        String NestedPojo_Json = "{\"Id\" : \"10\",\"nestedPojos\":[{\"name\" : Rahul, \"value\" : \"42\"},{\"name\" : Naveen, \"value\" : \"24\"}]}";

        Gson gson = new Gson();

        Pojo pojo = gson.fromJson(NestedPojo_Json,Pojo.class);

        return pojo;
    }
}
