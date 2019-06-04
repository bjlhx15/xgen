package com.github.bjlhx15.xgen.util.readxml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;





public class Parser
{
  private static final String BACKLASH = "/";
  private static final String DOT = ".";
  private static final String DOLLAR = "$";
  private static final String OPEN_BRACKET = "[";
  private static final String CLOSE_BRACKET = "]";
  private static List<String> listElePath = null;



  private static class MementoImpl
    implements ParseMemento
  {
    private Map<String, ReadXmlExpression> mapRe = new HashMap();

    public MementoImpl(Map<String, ReadXmlExpression> mapRe) { this.mapRe = mapRe; }


    public Map<String, ReadXmlExpression> getMapRe() { return this.mapRe; }
  }








  public static ReadXmlExpression parse(String expr) {
    ReadXmlExpression retObj = null;

    ParseMemento memento = ParseCaretaker.getInstance().retriveMemento();

    Map<String, ReadXmlExpression> mapRe = null;
    if (memento == null) {
      mapRe = new HashMap<String, ReadXmlExpression>();
    } else {
      mapRe = ((MementoImpl)memento).getMapRe();
    }


    String notParseExpr = searchMaxLongEquals(expr, mapRe);

    String needParseExpr = "";
    if (notParseExpr.trim().length() == 0) {
      needParseExpr = expr;
    }
    else if (notParseExpr.length() < expr.length()) {
      needParseExpr = expr.substring(notParseExpr.length() + 1);
    } else {
      needParseExpr = "";
    }


    if (needParseExpr.trim().length() > 0) {
      retObj = parse2(needParseExpr, notParseExpr, mapRe);
    } else {
      retObj = (ReadXmlExpression)mapRe.get(notParseExpr);
    }


    ParseCaretaker.getInstance().saveMemento(new MementoImpl(mapRe));

    return retObj;
  }






  private static String searchMaxLongEquals(String expr, Map<String, ReadXmlExpression> mapRe) {
    boolean flag = mapRe.containsKey(expr);
    while (!flag) {
      int lastIndex = expr.lastIndexOf("/");
      if (lastIndex > 0) {
        expr = expr.substring(0, lastIndex);

        flag = mapRe.containsKey(String.valueOf(expr) + "/"); continue;
      }
      expr = "";
      flag = true;
    }


    return expr;
  }



  private static ReadXmlExpression parse2(String needParseExpr, String notParseExpr, Map<String, ReadXmlExpression> mapRe) {
    listElePath = new ArrayList();


    Map<String, ParseModel> mapPath = parseMapPath(needParseExpr);

    Map<String, ReadXmlExpression> mapPathAndRe = mapPath2Expression(mapPath);

    ReadXmlExpression prefixRE = (ReadXmlExpression)mapRe.get(String.valueOf(notParseExpr) + "/");

    if (prefixRE != null) {
      prefixRE = (ReadXmlExpression)((ReadXmlExpression)mapRe.get(String.valueOf(notParseExpr) + "/")).clone();
    }

    return buildTree(notParseExpr, prefixRE, mapPathAndRe, mapRe);
  }










  private static Map<String, ParseModel> parseMapPath(String expr) {
    Map<String, ParseModel> mapPath = new HashMap<String, ParseModel>();


    StringBuffer pathBuffer = new StringBuffer();

    StringTokenizer tokenizer = new StringTokenizer(expr, "/");
    while (tokenizer.hasMoreTokens()) {
      String onePath = tokenizer.nextToken();
      if (tokenizer.hasMoreTokens()) {


        pathBuffer.append(String.valueOf(onePath) + "/");

        setParsePath(pathBuffer, onePath, false, false, mapPath);
        continue;
      }
      int dotIndex = onePath.indexOf(".");
      if (dotIndex > 0) {

        String eleName = onePath.substring(0, dotIndex);
        String propName = onePath.substring(dotIndex + 1);


        pathBuffer.append(String.valueOf(eleName) + ".");

        setParsePath(pathBuffer, eleName, false, false, mapPath);


        pathBuffer.append(propName);

        setParsePath(pathBuffer, propName, true, true, mapPath);
        break;
      }
      pathBuffer.append(onePath);

      setParsePath(pathBuffer, onePath, true, false, mapPath);


      break;
    }

    return mapPath;
  }

  private static void setParsePath(StringBuffer buffer, String eleName, boolean end, boolean propertyValue, Map<String, ParseModel> mapPath) {
    ParseModel pm = new ParseModel();
    pm.setEnd(end);
    pm.setPropertyValue(propertyValue);

    pm.setSingleValue(!(eleName.indexOf("$") > 0));


    eleName = eleName.replace("$", "");

    int tempBegin = 0;
    int tempEnd = 0;
    if ((tempBegin = eleName.indexOf("[")) > 0) {
      tempEnd = eleName.indexOf("]");

      pm.setCondition(eleName.substring(tempBegin + 1, tempEnd));

      eleName = eleName.substring(0, tempBegin);
    }

    pm.setEleName(eleName);

    mapPath.put(buffer.toString(), pm);

    listElePath.add(buffer.toString());
  }








  private static Map<String, ReadXmlExpression> mapPath2Expression(Map<String, ParseModel> mapPath) {
    Map<String, ReadXmlExpression> map = new HashMap<String, ReadXmlExpression>();
    for (String key : listElePath) {
      ParseModel pm = (ParseModel)mapPath.get(key);
      ReadXmlExpression obj = parseModel2ReadXmlExpression(pm);

      map.put(key, obj);
    }

    return map;
  }

  private static ReadXmlExpression parseModel2ReadXmlExpression(ParseModel pm) {
    ReadXmlExpression obj = null;
    if (!pm.isEnd()) {
      if (pm.isSingleValue()) {
        obj = new ElementExpression(pm.getEleName(), pm.getCondition());
      } else {
        obj = new ElementsExpression(pm.getEleName(), pm.getCondition());
      }

    } else if (pm.isPropertyValue()) {
      if (pm.isSingleValue()) {
        obj = new PropertyTerminalExpression(pm.getEleName());
      } else {
        obj = new PropertysTerminalExpression(pm.getEleName());
      }

    } else if (pm.isSingleValue()) {
      obj = new ElementTerminalExpression(pm.getEleName(), pm.getCondition());
    } else {
      obj = new ElementsTerminalExpression(pm.getEleName(), pm.getCondition());
    }


    return obj;
  }








  private static ReadXmlExpression buildTree(String prefixStr, ReadXmlExpression prefixRe, Map<String, ReadXmlExpression> mapPathAndRe, Map<String, ReadXmlExpression> mapRe) {
    ReadXmlExpression retRe = prefixRe;

    ReadXmlExpression preRe = getLastRE(prefixRe);

    for (String path : listElePath) {
      ReadXmlExpression re = (ReadXmlExpression)mapPathAndRe.get(path);

      if (preRe == null) {
        preRe = re;
        retRe = re;

      }
      else if (preRe instanceof ElementExpression) {
        ElementExpression ele = (ElementExpression)preRe;
        ele.addEle(re);

        preRe = re;
      } else if (preRe instanceof ElementsExpression) {
        ElementsExpression eles = (ElementsExpression)preRe;
        eles.addEle(re);

        preRe = re;
      }


      if (prefixStr != null && prefixStr.trim().length() > 0) {
        mapRe.put(String.valueOf(prefixStr) + "/" + path, (ReadXmlExpression)retRe.clone()); continue;
      }
      mapRe.put(path, (ReadXmlExpression)retRe.clone());
    }


    return retRe;
  }





  private static ReadXmlExpression getLastRE(ReadXmlExpression prefixRe) {
    ReadXmlExpression lastRe = prefixRe;
    boolean flag = true;

    while (flag) {
      if (lastRe instanceof ElementExpression) {
        if (((ElementExpression)lastRe).getEles().size() > 0) {

          lastRe = (ReadXmlExpression)((ElementExpression)lastRe).getEles().get(0);
          if (lastRe instanceof ElementExpression) {
            flag = (((ElementExpression)lastRe).getEles().size() > 0); continue;
          }  if (lastRe instanceof ElementsExpression) {
            flag = (((ElementsExpression)lastRe).getEles().size() > 0); continue;
          }
          flag = false;
          continue;
        }
        flag = false; continue;
      }
      if (lastRe instanceof ElementsExpression) {
        if (((ElementsExpression)lastRe).getEles().size() > 0) {
          lastRe = (ReadXmlExpression)((ElementsExpression)lastRe).getEles().get(0);
          if (lastRe instanceof ElementExpression) {
            flag = (((ElementExpression)lastRe).getEles().size() > 0); continue;
          }  if (lastRe instanceof ElementsExpression) {
            flag = (((ElementsExpression)lastRe).getEles().size() > 0); continue;
          }
          flag = false;
          continue;
        }
        flag = false;
        continue;
      }
      flag = false;
    }

    return lastRe;
  }
}