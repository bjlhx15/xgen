package com.github.bjlhx15.xgen.genconf.implementors;

import com.github.bjlhx15.xgen.genconf.vo.GenTypeModel;

import java.util.Map;

public interface ThemeImplementer {
  Map<String, GenTypeModel> getMapGenTypes(String paramString, Map<String, String> paramMap);
  
  Map<String, String> getMapGenOutTypes(String paramString, Map<String, String> paramMap);
  
  Map<String, String> getMapProviders(String paramString, Map<String, String> paramMap);
}
