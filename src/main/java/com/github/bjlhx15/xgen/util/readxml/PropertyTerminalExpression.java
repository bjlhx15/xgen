package com.github.bjlhx15.xgen.util.readxml;

import org.w3c.dom.Element;



public class PropertyTerminalExpression
  extends ReadXmlExpression
{
  private String propName;

  public PropertyTerminalExpression(String propName) { this.propName = propName; }



  public String[] interpret(Context ctx) {
    String[] ss = new String[1];

    Element pEle = (Element)ctx.getPreEles().get(0);

    ss[0] = pEle.getAttribute(this.propName);
    return ss;
  }

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