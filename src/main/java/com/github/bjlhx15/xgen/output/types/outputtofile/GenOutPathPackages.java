package com.github.bjlhx15.xgen.output.types.outputtofile;

import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;

public interface GenOutPathPackages {
  boolean genPackages(ModuleConfModel paramModuleConfModel, String paramString);
  
  String getOutPathAndFileName(ModuleConfModel paramModuleConfModel, String paramString);
}