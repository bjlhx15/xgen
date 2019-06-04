package com.github.bjlhx15.xgen.genconf.vo;

import java.util.HashMap;
import java.util.Map;

public class NeedGenModel
{
  private String id;
  private String provider;
  private String theme;
  private Map<String, String> mapParams = new HashMap();


  public String getId() { return this.id; }



  public void setId(String id) { this.id = id; }



  public String getProvider() { return this.provider; }



  public void setProvider(String provider) { this.provider = provider; }



  public String getTheme() { return this.theme; }



  public void setTheme(String theme) { this.theme = theme; }



  public Map<String, String> getMapParams() { return this.mapParams; }



  public void setMapParams(Map<String, String> mapParams) { this.mapParams = mapParams; }



  public String toString() {
    return "NeedGenModel [id=" + this.id + ", provider=" + this.provider + ", theme=" +
      this.theme + ", mapParams=" + this.mapParams + "]";
  }
}