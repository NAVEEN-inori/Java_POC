package com;

import java.util.List;

public class Organisation {

    private String Organisation_name;
    private String description;
    private int Employees;
    private List<Integer> list;

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    // Creating getters and setters
    public String getOrganisation_name() {
        return Organisation_name;
    }

    public void setOrganisation_name(String organisation_name) {
        Organisation_name = organisation_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmployees() {
        return Employees;
    }

    public void setEmployees(int employees) {
        Employees = employees;
    }

     // Creating toString

    @Override
    public String toString() {
        return "Organisation{" +
                "Organisation_name='" + Organisation_name + '\'' +
                ", description='" + description + '\'' +
                ", Employees=" + Employees +
                ", list=" + list +
                '}';
    }
}
