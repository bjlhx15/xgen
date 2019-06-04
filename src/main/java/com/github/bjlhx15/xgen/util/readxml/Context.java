package com.github.bjlhx15.xgen.util.readxml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class Context {
    private Document document = null;


    private List<Element> preEles = new ArrayList();


    private static Map<String, Context> mapCtx = new HashMap();


    private Context(Document document) {
        this.document = document;
    }


    public static Context getInstance(String filePathName) throws Exception {
        Context c = (Context) mapCtx.get(filePathName);
        if (c == null) {
            Document document = XmlUtil.getDocument(filePathName);
            c = new Context(document);

            mapCtx.put(filePathName, c);
        }

        c.init();

        return c;
    }

    public void init() {
        this.preEles = new ArrayList();
    }


    public List<Element> getPreEles() {
        return this.preEles;
    }


    public void setPreEles(List<Element> preEles) {
        this.preEles = preEles;
    }


    public Document getDocument() {
        return this.document;
    }


    public List<Element> getNowEles(Element pEle, String eleName) {
        List<Element> nowEles = new ArrayList<Element>();
        NodeList tempList = pEle.getChildNodes();
        for (int i = 0; i < tempList.getLength(); i++) {
            if (tempList.item(i) instanceof Element) {
                Element ele = (Element) tempList.item(i);
                if (ele.getTagName().equals(eleName)) {
                    nowEles.add(ele);
                }
            }
        }
        return nowEles;
    }


    public boolean judgeCondition(Element ele, String condition) {
        if (condition == null || condition.trim().length() == 0) {
            return true;
        }

        String[] ss = condition.split("=");
        if (ss[1] != null && ss[1].equals(ele.getAttribute(ss[0]))) {
            return true;
        }

        return false;
    }
}