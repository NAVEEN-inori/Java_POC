package com;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ObjectToJason {

    public static void main(String[] args) {

        // Creating object of organisation
        Organisation organisation = new Organisation();

        // Insert the data into the object
        organisation = getObjectData(organisation);

        // Creating Object of ObjectMapper define in Jakson Api
        ObjectMapper objectMapper = new ObjectMapper();

        try{

            // get Oraganisation object as a json string
            String jsonStr = objectMapper.writeValueAsString(organisation);

            // Displaying json String
            System.out.println(jsonStr);

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public static Organisation getObjectData(Organisation organisation){

        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);

        organisation.setOrganisation_name("GeeksforGeeks");
        organisation.setDescription("A computer science portal for Geeks");
        organisation.setEmployees(2000);
        organisation.setList(list);

        return organisation;
    }

}



