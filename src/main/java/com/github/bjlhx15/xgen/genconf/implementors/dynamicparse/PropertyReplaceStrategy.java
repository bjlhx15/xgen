package com.github.bjlhx15.xgen.genconf.implementors.dynamicparse;

import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.GenConfModel;

import java.util.Map;


public class PropertyReplaceStrategy
        implements ParseStrategy {
    public String parseDynamicContent(GenConfModel gm, Map<String, ExtendConfModel> mapEcms, String expr) {
        String retStr = "";
        ExtendConfModel ecm = (ExtendConfModel) mapEcms.get(expr);
        if (ecm != null) {
            retStr = ecm.getValue();
        }

        return retStr;
    }
}