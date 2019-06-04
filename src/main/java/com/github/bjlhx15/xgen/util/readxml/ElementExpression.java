package com.github.bjlhx15.xgen.util.readxml;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;



public class ElementExpression
  extends ReadXmlExpression
{
  private List<ReadXmlExpression> eles = new ArrayList();



  public void setEles(List<ReadXmlExpression> eles) { this.eles = eles; }




  private String eleName = "";



  private String condition = "";

  public ElementExpression(String eleName, String condition) {
    this.eleName = eleName;
    this.condition = condition;
  }

  public List<ReadXmlExpression> getEles() { return this.eles; }



  public void addEle(ReadXmlExpression ele) { this.eles.add(ele); }

  public boolean removeEle(ReadXmlExpression ele) {
    this.eles.remove(ele);
    return true;
  }


  public void removeAllEles() { this.eles.clear(); }





  public String[] interpret(Context ctx) {
    List<Element> pEles = ctx.getPreEles();
    Element ele = null;

    List<Element> nowEles = new ArrayList<Element>();

    if (pEles.size() == 0) {

      ele = ctx.getDocument().getDocumentElement();
      pEles.add(ele);

      ctx.setPreEles(pEles);
    } else {

      for (Element pEle : pEles) {
        nowEles.addAll(ctx.getNowEles(pEle, this.eleName));
        if (nowEles.size() > 0) {
          break;
        }
      }


      if (nowEles.size() > 0 && ctx.judgeCondition((Element)nowEles.get(0), this.condition)) {
        List<Element> tempList = new ArrayList<Element>();
        tempList.add((Element)nowEles.get(0));

        ctx.setPreEles(tempList);
      }
    }

    String[] ss = null;

    for (ReadXmlExpression tempEle : this.eles) {
      ss = tempEle.interpret(ctx);
    }

    return ss;
  }

  public Object clone() {
    ElementExpression obj = null;
    try {
      obj = (ElementExpression)super.clone();

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