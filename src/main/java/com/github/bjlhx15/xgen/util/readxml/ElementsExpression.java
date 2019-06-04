package com.github.bjlhx15.xgen.util.readxml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Element;




public class ElementsExpression
  extends ReadXmlExpression
{
  private List<ReadXmlExpression> eles = new ArrayList();

  public void setEles(List<ReadXmlExpression> eles) { this.eles = eles; }




  public List<ReadXmlExpression> getEles() { return this.eles; }





  private String eleName = "";



  private String condition = "";

  public ElementsExpression(String eleName, String condition) {
    this.eleName = eleName;
    this.condition = condition;
  }



  public void addEle(ReadXmlExpression ele) { this.eles.add(ele); }

  public boolean removeEle(ReadXmlExpression ele) {
    this.eles.remove(ele);
    return true;
  }


  public void removeAllEles() { this.eles.clear(); }




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

    ctx.setPreEles(nowEles);


    String[] ss = null;

    for (ReadXmlExpression tempEle : this.eles) {
      ss = tempEle.interpret(ctx);
    }

    return ss;
  }

  public Object clone() {
    ElementsExpression obj = null;
    try {
      obj = (ElementsExpression)super.clone();

      List<ReadXmlExpression> objEles = new ArrayList<ReadXmlExpression>();

      for (ReadXmlExpression re : this.eles) {
        objEles.add((ReadXmlExpression)re.clone());
      }
      obj.setEles(objEles);
    } catch (Exception err) {
      err.printStackTrace();
    }

    return obj;
  }
}