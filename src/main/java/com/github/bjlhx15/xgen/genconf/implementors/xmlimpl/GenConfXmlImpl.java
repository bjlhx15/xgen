package com.github.bjlhx15.xgen.genconf.implementors.xmlimpl;

import com.github.bjlhx15.xgen.genconf.constants.ExpressionEnum;
import com.github.bjlhx15.xgen.genconf.implementors.GenConfImplementor;
import com.github.bjlhx15.xgen.genconf.implementors.ThemeImplementer;
import com.github.bjlhx15.xgen.genconf.vo.NeedGenModel;
import com.github.bjlhx15.xgen.genconf.vo.ThemeModel;
import com.github.bjlhx15.xgen.util.readxml.Context;
import com.github.bjlhx15.xgen.util.readxml.Parser;
import com.github.bjlhx15.xgen.util.readxml.ReadXmlExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;







public class GenConfXmlImpl
  implements GenConfImplementor
{
  public List<NeedGenModel> getNeedGens() { return readNeedGends(); }




  public List<ThemeModel> getThemes() { return readThemes(); }




  public Map<String, String> getMapConstants() { return readMapConstants(); }



  private Context getContext() {
    Context c = null;
    try {
      c = Context.getInstance((
          (GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addXmlFilePre()).addGenConf().addDot()).addXml()).build());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return c;
  }

  private Map<String, String> readMapConstants() {
    Map<String, String> map = new HashMap<String, String>();
    Context c = getContext();

    String[] ids = parseConstantIds(c);
    String[] values = parseConstantValues(c);

    for (int i = 0; i < ids.length; i++) {
      map.put(ids[i], values[i]);
    }
    return map;
  }
  private String[] parseConstantValues(Context c) {
    c.init();
    ReadXmlExpression re = Parser.parse((
        (GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addConstants().addSeparator())
        .addConstant().addDollar())
        .build());

    return re.interpret(c);
  }
  private String[] parseConstantIds(Context c) {
    c.init();
    ReadXmlExpression re = Parser.parse((
        (GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addConstants().addSeparator())
        .addConstant().addDollar())
        .addDot()).addId()).addDollar())
        .build());

    return re.interpret(c);
  }



  private List<ThemeModel> readThemes() {
    List<ThemeModel> retList = new ArrayList<ThemeModel>();
    Context c = getContext();

    String[] ids = parseThemeIds(c);
    String[] locations = parseThemeLocations(c);

    for (int i = 0; i < ids.length; i++) {
      ThemeModel tm = new ThemeModel();

      ThemeImplementer themeImpl = new ThemeXmlImpl();

      Map<String, String> params = new HashMap<String, String>();
      params.put(ExpressionEnum.location.getExpr(), locations[i]);

      tm.setId(ids[i]);
      tm.setLocation(locations[i]);
      tm.setMapGenOutTypes(themeImpl.getMapGenOutTypes(ids[i], params));
      tm.setMapGenTypes(themeImpl.getMapGenTypes(ids[i], params));
      tm.setMapProviders(themeImpl.getMapProviders(ids[i], params));

      retList.add(tm);
    }

    return retList;
  }
  private String[] parseThemeLocations(Context c) {
    c.init();
    ReadXmlExpression re = Parser.parse((
        (GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addThemes().addSeparator())
        .addTheme().addDollar())
        .build());

    return re.interpret(c);
  }
  private String[] parseThemeIds(Context c) {
    c.init();
    ReadXmlExpression re = Parser.parse((
        (GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addThemes().addSeparator())
        .addTheme().addDollar())
        .addDot()).addId()).addDollar())
        .build());

    return re.interpret(c);
  }



  private List<NeedGenModel> readNeedGends() {
    List<NeedGenModel> retList = new ArrayList<NeedGenModel>();
    Context c = getContext();

    String[] needGenIds = parseNeedGenIds(c);
    String[] needGenProviders = parseNeedGenProviders(c);
    String[] needGenThemes = parseNeedGenThemes(c);


    for (int i = 0; i < needGenIds.length; i++) {
      NeedGenModel ngm = new NeedGenModel();

      ngm.setId(needGenIds[i]);
      ngm.setProvider(needGenProviders[i]);
      ngm.setTheme(needGenThemes[i]);


      String[] paramIds = parseParamIds(c, ngm.getId());
      String[] paramValues = parseParamValues(c, ngm.getId());


      Map<String, String> mapParams = new HashMap<String, String>();

      for (int j = 0; j < paramIds.length; j++) {
        mapParams.put(paramIds[j], paramValues[j]);
      }

      ngm.setMapParams(mapParams);


      retList.add(ngm);
    }

    return retList;
  }
  private String[] parseParamValues(Context c, String needGenId) {
    c.init();
    ReadXmlExpression re = Parser.parse((
        (GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addNeedGens().addSeparator())
        .addNeedGen().addDollar())
        .addOpenBracket()).addId()).addEqual()).addOtherValue(needGenId)).addCloseBracket())
        .addSeparator()).addParams().addDollar()).addSeparator()).addParam().addDollar())
        .build());

    return re.interpret(c);
  }
  private String[] parseParamIds(Context c, String needGenId) {
    c.init();
    ReadXmlExpression re = Parser.parse((
        (GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addNeedGens().addSeparator())
        .addNeedGen().addDollar())
        .addOpenBracket()).addId()).addEqual()).addOtherValue(needGenId)).addCloseBracket())
        .addSeparator()).addParams().addDollar()).addSeparator()).addParam().addDollar())
        .addDot()).addId()).addDollar())
        .build());

    return re.interpret(c);
  }
  private String[] parseNeedGenThemes(Context c) {
    c.init();
    ReadXmlExpression re = Parser.parse((
        (GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addNeedGens().addSeparator())
        .addNeedGen().addDollar()).addDot()).addThemeId().addDollar())
        .build());

    return re.interpret(c);
  }
  private String[] parseNeedGenProviders(Context c) {
    c.init();
    ReadXmlExpression re = Parser.parse((
        (GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addNeedGens().addSeparator())
        .addNeedGen().addDollar()).addDot()).addProvider().addDollar())
        .build());

    return re.interpret(c);
  }
  private String[] parseNeedGenIds(Context c) {
    c.init();

    ReadXmlExpression re = Parser.parse((
        (GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addGenConf().addSeparator()).addNeedGens().addSeparator())
        .addNeedGen().addDollar()).addDot()).addId()).addDollar())
        .build());

    return re.interpret(c);
  }
}