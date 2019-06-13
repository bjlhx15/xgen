package com.github.bjlhx15.xgen.genconf.confmanger;

import com.github.bjlhx15.xgen.genconf.implementors.GenConfImplementor;
import com.github.bjlhx15.xgen.genconf.implementors.ModuleGenConfImplementor;
import com.github.bjlhx15.xgen.genconf.vo.GenConfModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.genconf.vo.NeedGenModel;

import java.util.*;


public class ConfManager {

    private static ConfManager manager = null;
    private GenConfModel genConf;
    private Map mapModuleConf;

    private ConfManager(GenConfImplementor provider) {
        genConf = new GenConfModel();
        mapModuleConf = new HashMap();
        readConf(provider);
    }

    public static ConfManager getInstance(GenConfImplementor provider) {
        if (manager == null)
            manager = new ConfManager(provider);
        return manager;
    }

    public GenConfModel getGenConf() {
        return genConf;
    }

    public Map getMapModuleConf() {
        return mapModuleConf;
    }

    private void readConf(GenConfImplementor provider) {
        readGenConf(provider);
        NeedGenModel ngm;
        for (Iterator iterator = genConf.getNeedGens().iterator(); iterator.hasNext(); readOneModuleGenConf(ngm))
            ngm = (NeedGenModel) iterator.next();

    }

    private void readOneModuleGenConf(NeedGenModel ngm) {
        ModuleConfModel mcm = new ModuleConfModel();
        String providerClassName = (String) genConf.getThemeById(ngm.getTheme()).getMapProviders().get(ngm.getProvider());
        ModuleGenConfImplementor userGenConfImpl = null;
        try {
            userGenConfImpl = (ModuleGenConfImplementor) Class.forName(providerClassName).newInstance();
        } catch (Exception err) {
            err.printStackTrace();
        }
        mcm = userGenConfImpl.getBaseModuleConfModel(ngm.getMapParams());
        mcm.setUseTheme(ngm.getTheme());
        mcm.setMapNeedGendTypes(userGenConfImpl.getMapNeedGenTypes(ngm.getMapParams()));
        mcm.setMapExtends(userGenConfImpl.getMapExtends(genConf, ngm.getMapParams()));
        mapModuleConf.put(mcm.getModuleId(), mcm);
    }

    private void readGenConf(GenConfImplementor provider) {
        genConf.setNeedGens(provider.getNeedGens());
        genConf.setThemes(provider.getThemes());
        genConf.setMapConstants(provider.getMapConstants());
    }

}