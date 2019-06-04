package com.github.bjlhx15.xgen.genconf.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ModuleConfModel
{
  private String moduleId = "";



  private String useTheme = "";



  private Map<String, List<String>> mapNeedGendTypes = new HashMap();



  private Map<String, ExtendConfModel> mapExtends = new HashMap();

  public String getModuleId() { return this.moduleId; }


  public void setModuleId(String moduleId) { this.moduleId = moduleId; }


  public String getUseTheme() { return this.useTheme; }


  public void setUseTheme(String useTheme) { this.useTheme = useTheme; }


  public Map<String, List<String>> getMapNeedGendTypes() { return this.mapNeedGendTypes; }


  public void setMapNeedGendTypes(Map<String, List<String>> mapNeedGendTypes) { this.mapNeedGendTypes = mapNeedGendTypes; }


  public Map<String, ExtendConfModel> getMapExtends() { return this.mapExtends; }


  public void setMapExtends(Map<String, ExtendConfModel> mapExtends) { this.mapExtends = mapExtends; }


  public String toString() {
    return "ModuleConfModel [moduleId=" + this.moduleId + ", useTheme=" +
      this.useTheme + ", mapNeedGendTypes=" + this.mapNeedGendTypes +
      ", mapExtends=" + this.mapExtends + "]";
  }
}