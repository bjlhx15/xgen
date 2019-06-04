package com.github.bjlhx15.xgen.template.flyweight;

import com.github.bjlhx15.xgen.genconf.constants.ExpressionEnum;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.mediator.CoreMediator;
import com.github.bjlhx15.xgen.util.file.FileHelper;
import java.util.HashMap;
import java.util.Map;


public class TemplateFlyweightFactory
{
  private static TemplateFlyweightFactory factory = new TemplateFlyweightFactory();




  public static TemplateFlyweightFactory getInstance() { return factory; }


  Map<String, DefaultTemplate> mapTemplate = new HashMap();


  public DefaultTemplate getTemplateFlyweight(String templatePath) {
    Object obj = this.mapTemplate.get(templatePath);
    if (obj == null) {
      DefaultTemplate dt = new DefaultTemplate(FileHelper.readFile(templatePath));
      this.mapTemplate.put(templatePath, dt);
      return dt;
    }
    return (DefaultTemplate)obj;
  }



  public DefaultTemplate getTemplateFlyweight(ModuleConfModel moduleConf, String genTypeId) {
    String mbPathFile = CoreMediator.getInstance().getThemeMbPathFile(moduleConf, genTypeId);
    String themePath = CoreMediator.getInstance().getThemePath(moduleConf);

    String templatePath = String.valueOf(themePath) + ExpressionEnum.separator.getExpr() +
      ExpressionEnum.template.getExpr() +
      ExpressionEnum.separator.getExpr() +
      mbPathFile;
    return getTemplateFlyweight(templatePath);
  }
}