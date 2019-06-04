package com.github.bjlhx15.xgen.genconf;

import com.github.bjlhx15.xgen.genconf.vo.GenConfModel;
import com.github.bjlhx15.xgen.genconf.vo.GenTypeModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;

import java.util.Map;

public interface GenConfEbi {
    GenConfModel getGenConf();

    Map<String, ModuleConfModel> getMapModuleConf();

    GenTypeModel getThemeGenType(ModuleConfModel paramModuleConfModel, String paramString);

    String getThemeGenOutTypeClass(ModuleConfModel paramModuleConfModel, String paramString);
}