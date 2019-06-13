package com.github.bjlhx15.xgen.mediator;

import com.github.bjlhx15.xgen.genconf.GenConfFactory;
import com.github.bjlhx15.xgen.genconf.implementors.GenConfImplementor;
import com.github.bjlhx15.xgen.genconf.implementors.xmlimpl.GenConfXmlImpl;
import com.github.bjlhx15.xgen.genconf.vo.GenTypeModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.geninvocation.DefaultGenInvocation;
import com.github.bjlhx15.xgen.geninvocation.GenInvocation;
import com.github.bjlhx15.xgen.geninvocation.GenInvocationFactory;
import com.github.bjlhx15.xgen.genproxy.GenProxyFactory;
import com.github.bjlhx15.xgen.template.TemplateEbi;
import com.github.bjlhx15.xgen.template.TemplateFactory;

import java.util.*;

public class CoreMediator {

    private static CoreMediator mediator = new CoreMediator();

    private CoreMediator() {
    }

    public static CoreMediator getInstance() {
        return mediator;
    }

    public GenConfImplementor getDefaultGenConfProvider() {
        return new GenConfXmlImpl();
    }

    public Collection getNeedGenModuleConf(GenConfImplementor provider) {
        return GenConfFactory.createGenConfEbi(provider).getMapModuleConf().values();
    }

    public void needProxyGen(String needGenType, ModuleConfModel moduleConf) {
        GenProxyFactory.createGenProxy(needGenType, moduleConf).executeGen();
    }

    public GenInvocation getDefaultGenInvocation(String needGenType, ModuleConfModel moduleConf) {
        GenInvocation invocation = GenInvocationFactory.createGenInvocation(needGenType, moduleConf);
        return invocation;
    }

    public String getNeedGenTypeClass(String needGenType, ModuleConfModel moduleConf) {
        return GenConfFactory.createGenConfEbi().getThemeGenType(moduleConf, needGenType).getGenTypeClass();
    }

    public Object getTemplateContent(ModuleConfModel moduleConf, String genTypeId) {
        return TemplateFactory.createTemplateEbi(moduleConf, genTypeId);
    }

    public Object templateReplaceProperties(Object obj) {
        return ((TemplateEbi) obj).replaceProperties();
    }

    public Object templateReplaceMethods(Object obj) {
        return ((TemplateEbi) obj).replaceMethods();
    }

    public void registerObservers(DefaultGenInvocation ctx) {
        List needGenOutTypeIds = (List) ctx.getModuleConf().getMapNeedGendTypes().get(ctx.getNeedGenType());
        for (Iterator iterator = needGenOutTypeIds.iterator(); iterator.hasNext(); ) {
            String genOutTypeId = (String) iterator.next();
            String genOutTypeClass = GenConfFactory.createGenConfEbi().getThemeGenOutTypeClass(ctx.getModuleConf(), genOutTypeId);
            try {
                Observer o = (Observer) Class.forName(genOutTypeClass).newInstance();
                ctx.addObserver(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public String getThemeMbPathFile(ModuleConfModel moduleConf, String genTypeId) {
        return (String) ((GenTypeModel) GenConfFactory.createGenConfEbi().getGenConf().getThemeById(moduleConf.getUseTheme()).getMapGenTypes().get(genTypeId)).getMapParams().get("mbPathFile");
    }

    public String getThemePath(ModuleConfModel moduleConf) {
        return GenConfFactory.createGenConfEbi().getGenConf().getThemeById(moduleConf.getUseTheme()).getLocation();
    }

    public Map getGenTypeParams(ModuleConfModel moduleConf, String genTypeId) {
        return GenConfFactory.createGenConfEbi().getThemeGenType(moduleConf, genTypeId).getMapParams();
    }

    public ModuleConfModel getObserverModuleConf(Object obj) {
        DefaultGenInvocation invocation = (DefaultGenInvocation) obj;
        return invocation.getModuleConf();
    }

    public String getObserverGenTypeId(Object obj) {
        DefaultGenInvocation invocation = (DefaultGenInvocation) obj;
        return invocation.getNeedGenType();
    }

}