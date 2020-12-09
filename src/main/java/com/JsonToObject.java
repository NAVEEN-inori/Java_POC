package com;

import com.google.gson.Gson;

import java.util.List;

public class JsonToObject {

    public static void main(String[] args) {

        // Creating object of Organisation
        Organisation organisation = new Organisation();

        // Converting json to object
        organisation = getOrganisationObject();

        // Displaying object
        System.out.println(organisation);
    }

    public static Organisation getOrganisationObject(){

        //Intial JSON String:
        //{“organisation_name” : “GeeksforGeeks”, “description” : “A computer Science portal for Geeks”, “Employee” : “2000”}

        // This Json string should not be a simple Json String. Preprocess the JSON String and add slashes before passing it into GSON object.

        //Preprocessed JSON String:
        //{ \”organisation_name\” : \”GeeksforGeeks\”, \”description\” : \”A computer Science portal for Geeks\”, \”Employee\” : \”2000\” }

        // Storing preprocessed json(Added slashes)
        String OrganisationJson
                = "{\"Organisation_name\":\"GeeksforGeeks\",\"description\": \"A computer Science portal for Geeks\",\"Employees\": \"2000\"}";

        // Creating a Gson Object
        Gson gson = new Gson();

        // Converting json to object
        // first parameter should be prpreocessed json
        // and second should be mapping class

        Organisation organisation = gson.fromJson(OrganisationJson,Organisation.class);

        List<Integer> list = organisation.getList();

        organisation.getEmployees();

        // return object
        return organisation;
    }
}
