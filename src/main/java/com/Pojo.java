package com;

import java.util.Arrays;

public class Pojo {

    int Id;
    NestedPojo[] nestedPojos;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public NestedPojo[] getNestedPojos() {
        return nestedPojos;
    }

    public void setNestedPojos(NestedPojo[] nestedPojos) {
        this.nestedPojos = nestedPojos;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "Id=" + Id +
                ", nestedPojos=" + Arrays.toString(nestedPojos) +
                '}';
    }
}
