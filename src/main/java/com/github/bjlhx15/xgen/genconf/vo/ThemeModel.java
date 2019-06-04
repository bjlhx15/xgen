package com.github.bjlhx15.xgen.genconf.vo;

import java.util.HashMap;
import java.util.Map;

public class ThemeModel {
    private String id;
    private String location;
    private Map<String, GenTypeModel> mapGenTypes = new HashMap();
    private Map<String, String> mapGenOutTypes = new HashMap();
    private Map<String, String> mapProviders = new HashMap();

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, GenTypeModel> getMapGenTypes() {
        return this.mapGenTypes;
    }

    public void setMapGenTypes(Map<String, GenTypeModel> mapGenTypes) {
        this.mapGenTypes = mapGenTypes;
    }

    public Map<String, String> getMapGenOutTypes() {
        return this.mapGenOutTypes;
    }

    public void setMapGenOutTypes(Map<String, String> mapGenOutTypes) {
        this.mapGenOutTypes = mapGenOutTypes;
    }

    public Map<String, String> getMapProviders() {
        return this.mapProviders;
    }

    public void setMapProviders(Map<String, String> mapProviders) {
        this.mapProviders = mapProviders;
    }

    public String toString() {
        return "ThemeModel [id=" + this.id + ", location=" + this.location +
                ", mapGenTypes=" + this.mapGenTypes + ", mapGenOutTypes=" +
                this.mapGenOutTypes + ", mapProviders=" + this.mapProviders + "]";
    }
}