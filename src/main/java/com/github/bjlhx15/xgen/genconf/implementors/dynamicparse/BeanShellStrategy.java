package com.github.bjlhx15.xgen.genconf.implementors.dynamicparse;

import bsh.Interpreter;
import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.GenConfModel;

import java.util.Map;


public class BeanShellStrategy
        implements ParseStrategy {
    public String parseDynamicContent(GenConfModel gm, Map<String, ExtendConfModel> mapEcms, String expr) {
        Interpreter interpreter = new Interpreter();
        String retStr = "";

        try {
            interpreter.set("gm", gm);
            interpreter.set("mapEcms", mapEcms);


            interpreter.eval("retValue=" + expr);


            retStr = interpreter.get("retValue").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retStr;
    }
}