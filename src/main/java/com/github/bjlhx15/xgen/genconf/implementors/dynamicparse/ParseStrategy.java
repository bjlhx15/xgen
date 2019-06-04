package com.github.bjlhx15.xgen.genconf.implementors.dynamicparse;

import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.GenConfModel;

import java.util.Map;

public interface ParseStrategy {
    String parseDynamicContent(GenConfModel paramGenConfModel, Map<String, ExtendConfModel> paramMap, String paramString);
}