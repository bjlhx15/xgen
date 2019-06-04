package com.github.bjlhx15.xgen.output.types.outputtofile.plaintxt;

import com.github.bjlhx15.xgen.genconf.constants.ExpressionEnum;
import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.mediator.CoreMediator;
import com.github.bjlhx15.xgen.output.types.outputtofile.GenOutPathPackages;
import com.github.bjlhx15.xgen.util.file.FileHelper;

public class GenOutPathPackageImpl
  implements GenOutPathPackages
{
  public boolean genPackages(ModuleConfModel moduleConf, String genTypeId) {
    FileHelper.genDir(getDirPath(moduleConf, genTypeId));

    return true;
  }
  private String getDirPath(ModuleConfModel moduleConf, String genTypeId) {
    String codeOutPath = ((ExtendConfModel)moduleConf.getMapExtends().get("codeOutPath")).getValue();

    String relativePath = (String)CoreMediator.getInstance().getGenTypeParams(moduleConf, genTypeId).get("relativePath");
    String packagePath = ((ExtendConfModel)moduleConf.getMapExtends().get("modulePackge")).getValue();

    String dirPackages = String.valueOf(codeOutPath) + ExpressionEnum.dot.getExpr() +
      packagePath + ExpressionEnum.dot.getExpr() + relativePath;
    return dirPackages.replace(ExpressionEnum.dot.getExpr(), ExpressionEnum.separator.getExpr());
  }






  public String getOutPathAndFileName(ModuleConfModel moduleConf, String genTypeId) {
    String preName = (String)CoreMediator.getInstance().getGenTypeParams(moduleConf, genTypeId).get("preGenFileName");
    String afterName = (String)CoreMediator.getInstance().getGenTypeParams(moduleConf, genTypeId).get("afterGenFileName");


    String moduleNameSuperCase = ((ExtendConfModel)moduleConf.getMapExtends().get("moduleNameSuperCase")).getValue();

    String retName = String.valueOf(getDirPath(moduleConf, genTypeId)) +
      ExpressionEnum.separator.getExpr();

    if (preName.equalsIgnoreCase("use-after")) {
      retName = String.valueOf(retName) + afterName;
    } else {
      retName = String.valueOf(retName) + preName +
        moduleNameSuperCase +
        afterName;
    }

    return retName;
  }
}