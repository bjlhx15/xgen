package com.github.bjlhx15.xgen.genconf.implementors;

import com.github.bjlhx15.xgen.genconf.vo.NeedGenModel;
import com.github.bjlhx15.xgen.genconf.vo.ThemeModel;

import java.util.List;
import java.util.Map;

public interface GenConfImplementor {
  List<NeedGenModel> getNeedGens();
  
  List<ThemeModel> getThemes();
  
  Map<String, String> getMapConstants();
}