package com.github.bjlhx15.xgen.template;

import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.template.flyweight.TemplateFlyweight;
import com.github.bjlhx15.xgen.template.flyweight.TemplateFlyweightFactory;









public class DefaultTemplateEbo
  implements TemplateEbi
{
  private ModuleConfModel moduleConf;
  private String genTypeId;
  private Object nowContent;
  private TemplateFlyweight flyweight = null;

  public DefaultTemplateEbo(ModuleConfModel moduleConf, String genTypeId) {
    this.moduleConf = moduleConf;
    this.genTypeId = genTypeId;

    this.flyweight = TemplateFlyweightFactory.getInstance().getTemplateFlyweight(moduleConf, this.genTypeId);
    this.nowContent = this.flyweight.getRawContent();
  }



  public Object replaceProperties() {
    this.nowContent = this.flyweight.replaceProperties(this.moduleConf, this.nowContent);
    return this;
  }


  public Object replaceMethods() {
    this.nowContent = this.flyweight.replaceMethods(this.moduleConf, this.nowContent);
    return this;
  }



  public Object getNowContent() { return this.nowContent; }
}