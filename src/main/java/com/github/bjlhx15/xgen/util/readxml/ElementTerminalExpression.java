package com.github.bjlhx15.xgen.util.readxml;

import java.util.List;
import org.w3c.dom.Element;



public class ElementTerminalExpression
  extends ReadXmlExpression
{
  private String eleName = "";



  private String condition = "";

  public ElementTerminalExpression(String eleName, String condition) {
    this.eleName = eleName;
    this.condition = condition;
  }




  public String[] interpret(Context ctx) {
    List<Element> pEles = ctx.getPreEles();

    Element ele = null;

    if (pEles.size() == 0) {

      ele = ctx.getDocument().getDocumentElement();
    } else {
      ele = (Element)ctx.getNowEles((Element)pEles.get(0), this.eleName).get(0);
    }


    if (!ctx.judgeCondition(ele, this.condition)) {
      return new String[0];
    }


    String[] ss = new String[1];
    if (ele.getFirstChild() != null) {
      ss[0] = ele.getFirstChild().getNodeValue();
    } else {
      ss[0] = "";
    }

    return ss;
  }

  public Object clone() {
    ElementTerminalExpression obj = null;
    try {
      obj = (ElementTerminalExpression)super.clone();
    } catch (Exception err) {
      err.printStackTrace();
    }

    return obj;
  }
}