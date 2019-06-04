package com.github.bjlhx15.xgen.util.readxml;

public abstract class ReadXmlExpression
  implements Cloneable
{
  public abstract String[] interpret(Context paramContext);

  public Object clone() {
    Object obj = null;
    try {
      obj = super.clone();
    } catch (Exception err) {
      err.printStackTrace();
    }
    return obj;
  }
}