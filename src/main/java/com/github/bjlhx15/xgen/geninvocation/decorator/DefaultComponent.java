package com.github.bjlhx15.xgen.geninvocation.decorator;


import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;

public class DefaultComponent
        extends GenComponent {
    public Object operation(ModuleConfModel moduleConf, String genTypeId, Object obj) {
        return obj;
    }
}