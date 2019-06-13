package com.github.bjlhx15.xgen.genconf;


import com.github.bjlhx15.xgen.genconf.confmanger.ConfManager;
import com.github.bjlhx15.xgen.genconf.implementors.GenConfImplementor;
import com.github.bjlhx15.xgen.genconf.vo.GenConfModel;
import com.github.bjlhx15.xgen.genconf.vo.GenTypeModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;

import java.util.Map;

public class GenConfEbo
        implements GenConfEbi {

    private static GenConfEbo ebo = null;
    private GenConfImplementor provider;

    private GenConfEbo(GenConfImplementor provider) {
        this.provider = null;
        this.provider = provider;
    }

    public static GenConfEbi getInstance(GenConfImplementor provider) {
        if (ebo == null) {
            if (provider == null)
                throw new IllegalArgumentException("第一次创建配置对象时，provider不能为空");
            ebo = new GenConfEbo(provider);
        }
        return ebo;
    }

    public GenConfModel getGenConf() {
        return ConfManager.getInstance(provider).getGenConf();
    }

    public Map getMapModuleConf() {
        return ConfManager.getInstance(provider).getMapModuleConf();
    }

    public GenTypeModel getThemeGenType(ModuleConfModel moduleConf, String needGenTypeId) {
        return (GenTypeModel) getGenConf().getThemeById(moduleConf.getUseTheme()).getMapGenTypes().get(needGenTypeId);
    }

    public String getThemeGenOutTypeClass(ModuleConfModel moduleConf, String needGenOutTypeId) {
        return (String) getGenConf().getThemeById(moduleConf.getUseTheme()).getMapGenOutTypes().get(needGenOutTypeId);
    }

}