package com.github.bjlhx15.xgen.template;

import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;




public class TemplateFactory
{
  public static TemplateEbi createTemplateEbi(ModuleConfModel moduleConf, String genTypeId) { return new DefaultTemplateEbo(moduleConf, genTypeId); }
}