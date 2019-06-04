package com.github.bjlhx15.xgen.geninvocation.decorator;


import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.mediator.CoreMediator;

public class ReplaceProperty
        extends GenDecorator {
    public ReplaceProperty(GenComponent component) {
        super(component);
    }


    public Object operation(ModuleConfModel moduleConf, String genTypeId, Object obj) {
        obj = this.component.operation(moduleConf, genTypeId, obj);


        return CoreMediator.getInstance().templateReplaceProperties(obj);
    }
}