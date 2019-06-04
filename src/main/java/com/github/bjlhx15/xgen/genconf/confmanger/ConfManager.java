package com.github.bjlhx15.xgen.genconf.confmanger;

import com.github.bjlhx15.xgen.genconf.implementors.GenConfImplementor;
import com.github.bjlhx15.xgen.genconf.implementors.ModuleGenConfImplementor;
import com.github.bjlhx15.xgen.genconf.vo.GenConfModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.genconf.vo.NeedGenModel;

import java.util.HashMap;
import java.util.Map;



public class ConfManager
{
  private static ConfManager manager = null;

  private ConfManager(GenConfImplementor provider) { readConf(provider); }


  public static ConfManager getInstance(GenConfImplementor provider) {
    if (manager == null) {
      manager = new ConfManager(provider);
    }
    return manager;
  }

  private GenConfModel genConf = new GenConfModel();
  private Map<String, ModuleConfModel> mapModuleConf = new HashMap();



  public GenConfModel getGenConf() { return this.genConf; }



  public Map<String, ModuleConfModel> getMapModuleConf() { return this.mapModuleConf; }





  private void readConf(GenConfImplementor provider) {
    readGenConf(provider);
    for (NeedGenModel ngm : this.genConf.getNeedGens()) {
      readOneModuleGenConf(ngm);
    }
  }

  private void readOneModuleGenConf(NeedGenModel ngm) {
    ModuleConfModel mcm = new ModuleConfModel();

    String providerClassName = (String)this.genConf.getThemeById(ngm.getTheme()).getMapProviders().get(ngm.getProvider());

    ModuleGenConfImplementor userGenConfImpl = null;

    try {
      userGenConfImpl = (ModuleGenConfImplementor)Class.forName(providerClassName).newInstance();
    } catch (Exception err) {
      err.printStackTrace();
    }

    mcm = userGenConfImpl.getBaseModuleConfModel(ngm.getMapParams());
    mcm.setUseTheme(ngm.getTheme());

    mcm.setMapNeedGendTypes(userGenConfImpl.getMapNeedGenTypes(ngm.getMapParams()));


    mcm.setMapExtends(userGenConfImpl.getMapExtends(this.genConf, ngm.getMapParams()));


    this.mapModuleConf.put(mcm.getModuleId(), mcm);
  }


  private void readGenConf(GenConfImplementor provider) {
    this.genConf.setNeedGens(provider.getNeedGens());
    this.genConf.setThemes(provider.getThemes());
    this.genConf.setMapConstants(provider.getMapConstants());
  }
}