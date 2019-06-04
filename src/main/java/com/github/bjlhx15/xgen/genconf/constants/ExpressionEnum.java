package com.github.bjlhx15.xgen.genconf.constants;

public enum ExpressionEnum {
  dot("."), separator("/"), dollar("$"), openBracket("["),
  closeBracket("]"), equal("="), comma(","), xml("xml"), xmlFilePre("cn/javass/xgenconfxml/"),
  themeXmlName("ThemeConf.xml"), location("Location"), fileName("fileName"),
  propBeginStr("$#"), propEndStr("#"), methodBeginStr("$["), methodEndStr("]"),
  template("template");

  private String expr;


  ExpressionEnum(String expr) { this.expr = expr; }



  public String getExpr() { return this.expr; }
}