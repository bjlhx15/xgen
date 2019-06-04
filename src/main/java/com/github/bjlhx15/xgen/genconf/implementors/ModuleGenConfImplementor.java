package com.github.bjlhx15.xgen.genconf.implementors;
import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.GenConfModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;

import java.util.List;
import java.util.Map;

public interface ModuleGenConfImplementor {
  ModuleConfModel getBaseModuleConfModel(Map<String, String> paramMap);
  
  Map<String, List<String>> getMapNeedGenTypes(Map<String, String> paramMap);
  
  Map<String, ExtendConfModel> getMapExtends(GenConfModel paramGenConfModel, Map<String, String> paramMap);
}