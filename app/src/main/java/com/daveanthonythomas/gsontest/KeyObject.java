package com.daveanthonythomas.gsontest;

/**
 * Created by dave on 2016-10-28.
 */

public class KeyObject {

    private String name;
    private String variant;

    public KeyObject(String name, String variant) {
        this.name = name;
        this.variant = variant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "KeyObject{" +
                "name='" + name + '\'' +
                ", variant='" + variant + '\'' +
                '}';
    }
}
