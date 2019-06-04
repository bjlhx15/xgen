package com.github.bjlhx15.xgen.geninvocation;


import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.geninvocation.decorator.*;

public abstract class BaseGenAction {
    public Object generate(ModuleConfModel moduleConf) {
        Object obj = initObject();

        Object before = beforeAction(moduleConf);
        if (before != null) {
            obj = executeDecorators(moduleConf, obj, (GenComponent) before);
        }
        beforeAction(moduleConf);

        obj = execute(moduleConf, obj);

        Object after = afterAction(moduleConf);
        if (after != null) {
            obj = executeDecorators(moduleConf, obj, (GenComponent) after);
        }

        return obj;
    }


    public abstract Object initObject();


    public GenComponent beforeAction(ModuleConfModel moduleConf) {
        return null;
    }


    public abstract Object execute(ModuleConfModel paramModuleConfModel, Object paramObject);


    public GenComponent afterAction(ModuleConfModel moduleConf) {
        return null;
    }


    public abstract Object executeDecorators(ModuleConfModel paramModuleConfModel, Object paramObject, GenComponent paramGenComponent);


    public GenComponent defaultBeforeAction(ModuleConfModel moduleConf) {
        DefaultComponent defaultComponent = new DefaultComponent();

        ReadTemplateContent readTemplateContent = new ReadTemplateContent(defaultComponent);

        ReplaceProperty replaceProperty = new ReplaceProperty(readTemplateContent);

        return new ReplaceMethods(replaceProperty);
    }
}