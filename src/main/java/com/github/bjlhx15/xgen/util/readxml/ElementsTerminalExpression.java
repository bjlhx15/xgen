package com.github.bjlhx15.xgen.util.readxml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Element;



public class ElementsTerminalExpression
  extends ReadXmlExpression
{
  private String eleName = "";



  private String condition = "";

  public ElementsTerminalExpression(String eleName, String condition) {
    this.eleName = eleName;
    this.condition = condition;
  }



  public String[] interpret(Context ctx) {
    List<Element> pEles = ctx.getPreEles();

    List<Element> nowEles = new ArrayList<Element>();

    for (Element pEle : pEles) {
      nowEles.addAll(ctx.getNowEles(pEle, this.eleName));
    }

    Iterator<Element> it = nowEles.iterator();
    while (it.hasNext()) {
      Element ele = (Element)it.next();
      if (!ctx.judgeCondition(ele, this.condition)) {
        it.remove();
      }
    }


    String[] ss = new String[nowEles.size()];

    for (int i = 0; i < ss.length; i++) {
      Element ele = (Element)nowEles.get(i);
      if (ele.getFirstChild() != null) {
        ss[i] = ele.getFirstChild().getNodeValue();
      } else {
        ss[i] = "";
      }
    }

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