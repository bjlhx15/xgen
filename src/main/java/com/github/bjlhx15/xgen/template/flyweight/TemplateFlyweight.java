package com.github.bjlhx15.xgen.template.flyweight;

import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;

public interface TemplateFlyweight {
  Object replaceProperties(ModuleConfModel paramModuleConfModel, Object paramObject);
  
  Object replaceMethods(ModuleConfModel paramModuleConfModel, Object paramObject);
  
  Object getRawContent();
}