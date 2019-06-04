package com.github.bjlhx15.xgen.geninvocation.decorator;

import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.mediator.CoreMediator;

public class ReadTemplateContent
        extends GenDecorator {
    public ReadTemplateContent(GenComponent component) {
        super(component);
    }


    public Object operation(ModuleConfModel moduleConf, String genTypeId, Object obj) {
        return CoreMediator.getInstance().getTemplateContent(moduleConf, genTypeId);
    }
}