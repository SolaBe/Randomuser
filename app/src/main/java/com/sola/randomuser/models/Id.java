package com.sola.randomuser.models;

import java.io.Serializable;

/**
 * Created by Sola2Be on 04.07.2017.
 */

public class Id implements Serializable{

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
