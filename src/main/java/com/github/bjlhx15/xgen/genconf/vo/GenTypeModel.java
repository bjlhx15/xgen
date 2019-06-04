package com.github.bjlhx15.xgen.genconf.vo;

import java.util.HashMap;
import java.util.Map;

public class GenTypeModel {
  private String id;
  private String genTypeClass;
  private Map<String, String> mapParams = new HashMap();

  public String getId() { return this.id; }


  public void setId(String id) { this.id = id; }


  public String getGenTypeClass() { return this.genTypeClass; }


  public void setGenTypeClass(String genTypeClass) { this.genTypeClass = genTypeClass; }


  public Map<String, String> getMapParams() { return this.mapParams; }


  public void setMapParams(Map<String, String> mapParams) { this.mapParams = mapParams; }


  public String toString() {
    return "GenTypeModel [id=" + this.id + ", genTypeClass=" + this.genTypeClass +
      ", mapParams=" + this.mapParams + "]";
  }
}