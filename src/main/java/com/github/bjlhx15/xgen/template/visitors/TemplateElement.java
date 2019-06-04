package com.github.bjlhx15.xgen.template.visitors;

import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;

public class TemplateElement
{
  private ModuleConfModel moduleConf;

  public TemplateElement(ModuleConfModel moduleConf) { this.moduleConf = moduleConf; }







  public Object accept(Visitor v) { return v.visitTemplateElement(this); }



  public ModuleConfModel getModuleConf() { return this.moduleConf; }
}