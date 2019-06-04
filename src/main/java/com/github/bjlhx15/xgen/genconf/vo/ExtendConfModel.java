package com.github.bjlhx15.xgen.genconf.vo;

import java.util.Arrays;


public class ExtendConfModel {
    private String id;
    private String value;
    private String[] values;
    private boolean single = true;

    public String getId() {
        return this.id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getValue() {
        return this.value;
    }


    public void setValue(String value) {
        this.value = value;
    }


    public String[] getValues() {
        return this.values;
    }


    public void setValues(String[] values) {
        this.values = values;
    }


    public boolean isSingle() {
        return this.single;
    }


    public void setSingle(boolean single) {
        this.single = single;
    }


    public String toString() {
        return "ExtendConfModel [id=" + this.id + ", value=" + this.value + ", values=" +
                Arrays.toString(this.values) + ", single=" + this.single + "]";
    }
}