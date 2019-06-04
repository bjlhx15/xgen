package com.github.bjlhx15.xgen.geninvocation.decorator;


import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;

public abstract class GenDecorator
        extends GenComponent {
    protected GenComponent component;

    public GenDecorator(GenComponent component) {
        this.component = component;
    }

    public Object operation(ModuleConfModel moduleConf, String genTypeId, Object obj) {
        return this.component.operation(moduleConf, genTypeId, obj);
    }
}


