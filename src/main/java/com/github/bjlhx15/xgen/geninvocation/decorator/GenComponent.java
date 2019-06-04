package com.github.bjlhx15.xgen.geninvocation.decorator;


import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;

public abstract class GenComponent {
    public abstract Object operation(ModuleConfModel paramModuleConfModel, String paramString, Object paramObject);
}