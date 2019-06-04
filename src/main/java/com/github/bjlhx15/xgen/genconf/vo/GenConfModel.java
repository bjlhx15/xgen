package com.github.bjlhx15.xgen.genconf.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





public class GenConfModel
{
  private List<NeedGenModel> needGens = new ArrayList();



  private List<ThemeModel> themes = new ArrayList();



  private Map<String, String> mapConstants = new HashMap();


  public List<NeedGenModel> getNeedGens() { return this.needGens; }


  public void setNeedGens(List<NeedGenModel> needGens) { this.needGens = needGens; }


  public List<ThemeModel> getThemes() { return this.themes; }


  public void setThemes(List<ThemeModel> themes) { this.themes = themes; }


  public Map<String, String> getMapConstants() { return this.mapConstants; }


  public void setMapConstants(Map<String, String> mapConstants) { this.mapConstants = mapConstants; }



  public ThemeModel getThemeById(String themeId) {
    for (ThemeModel tm : this.themes) {
      if (tm.getId().equals(themeId)) {
        return tm;
      }
    }
    return new ThemeModel();
  }

  public String toString() {
    return "GenConfModel [needGens=" + this.needGens + ", themes=" + this.themes +
      ", mapConstants=" + this.mapConstants + "]";
  }
}