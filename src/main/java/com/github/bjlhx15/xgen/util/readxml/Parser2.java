package com.github.bjlhx15.xgen.util.readxml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Parser2 {
    private static final String BACKLASH = "/";
    private static final String DOT = ".";
    private static final String DOLLAR = "$";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static List<String> listEle = null;


    public static ReadXmlExpression parse(String expr) {
        listEle = new ArrayList();


        Map<String, ParseModel> mapPath = parseMapPath(expr);

        List<ReadXmlExpression> list = mapPath2Expression(mapPath);

        return buildTree(list);
    }


    private static Map<String, ParseModel> parseMapPath(String expr) {
        Map<String, ParseModel> mapPath = new HashMap<String, ParseModel>();

        StringTokenizer tokenizer = new StringTokenizer(expr, "/");
        while (tokenizer.hasMoreTokens()) {
            String onePath = tokenizer.nextToken();
            if (tokenizer.hasMoreTokens()) {

                setParsePath(onePath, false, false, mapPath);
                continue;
            }
            int dotIndex = onePath.indexOf(".");
            if (dotIndex > 0) {

                String eleName = onePath.substring(0, dotIndex);
                String propName = onePath.substring(dotIndex + 1);


                setParsePath(eleName, false, false, mapPath);

                setParsePath(propName, true, true, mapPath);
                break;
            }
            setParsePath(onePath, true, false, mapPath);


            break;
        }

        return mapPath;
    }

    private static void setParsePath(String eleName, boolean end, boolean propertyValue, Map<String, ParseModel> mapPath) {
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

        mapPath.put(eleName, pm);

        listEle.add(eleName);
    }


    private static List<ReadXmlExpression> mapPath2Expression(Map<String, ParseModel> mapPath) {
        List<ReadXmlExpression> list = new ArrayList<ReadXmlExpression>();
        for (String key : listEle) {
            ParseModel pm = (ParseModel) mapPath.get(key);
            ReadXmlExpression obj = parseModel2ReadXmlExpression(pm);

            list.add(obj);
        }

        return list;
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


    private static ReadXmlExpression buildTree(List<ReadXmlExpression> listExpression) {
        ReadXmlExpression retRe = null;

        ReadXmlExpression preRe = null;

        for (ReadXmlExpression re : listExpression) {
            if (preRe == null) {
                preRe = re;
                retRe = re;
                continue;
            }
            if (preRe instanceof ElementExpression) {
                ElementExpression ele = (ElementExpression) preRe;
                ele.addEle(re);

                preRe = re;
                continue;
            }
            if (preRe instanceof ElementsExpression) {
                ElementsExpression eles = (ElementsExpression) preRe;
                eles.addEle(re);

                preRe = re;
            }
        }


        return retRe;
    }
}