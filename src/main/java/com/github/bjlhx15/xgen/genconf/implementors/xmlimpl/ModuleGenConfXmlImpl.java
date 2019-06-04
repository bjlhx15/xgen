package com.github.bjlhx15.xgen.genconf.implementors.xmlimpl;

import com.github.bjlhx15.xgen.genconf.constants.ExpressionEnum;
import com.github.bjlhx15.xgen.genconf.implementors.ModuleGenConfImplementor;
import com.github.bjlhx15.xgen.genconf.implementors.dynamicparse.ParseContext;
import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.GenConfModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.util.readxml.Context;
import com.github.bjlhx15.xgen.util.readxml.Parser;
import com.github.bjlhx15.xgen.util.readxml.ReadXmlExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ModuleGenConfXmlImpl
        implements ModuleGenConfImplementor
{

  public ModuleGenConfXmlImpl()
  {
  }

  public ModuleConfModel getBaseModuleConfModel(Map param)
  {
    ModuleConfModel mcm = new ModuleConfModel();
    parseModuleId(mcm, getContext(param));
    return mcm;
  }

  public Map getMapNeedGenTypes(Map param)
  {
    return parseNeedGenTypes(getContext(param));
  }

  public Map getMapExtends(GenConfModel gm, Map param)
  {
    Map map = new HashMap();
    String extendIds[] = parseExtendIds(getContext(param));
    String isSingles[] = parseIsSingles(getContext(param));
    String values[] = parseValues(getContext(param));
    for (int i = 0; i < extendIds.length; i++)
    {
      ExtendConfModel ecm = new ExtendConfModel();
      ecm.setId(extendIds[i]);
      ecm.setSingle(Boolean.parseBoolean(isSingles[i]));
      ecm.setValue(values[i]);
      if (!ecm.isSingle())
        ecm.setValues(ecm.getValue().split(ExpressionEnum.comma.getExpr()));
      map.put(ecm.getId(), ecm);
    }

    ParseContext pctx = new ParseContext();
    map = pctx.parse(gm, map);
    return map;
  }

  private String[] parseValues(Context ctx)
  {
    ctx.init();
    ReadXmlExpression re = Parser.parse(((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)(new ModuleGenConfBuilder()).addModuleGenConf().addSeparator()).addExtendConfs().addSeparator()).addExtendConf().addDollar()).build());
    return re.interpret(ctx);
  }

  private String[] parseIsSingles(Context ctx)
  {
    ctx.init();
    ReadXmlExpression re = Parser.parse(((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)(new ModuleGenConfBuilder()).addModuleGenConf().addSeparator()).addExtendConfs().addSeparator()).addExtendConf().addDollar()).addDot()).addIsSingle().addDollar()).build());
    return re.interpret(ctx);
  }

  private String[] parseExtendIds(Context ctx)
  {
    ctx.init();
    ReadXmlExpression re = Parser.parse(((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)(new ModuleGenConfBuilder()).addModuleGenConf().addSeparator()).addExtendConfs().addSeparator()).addExtendConf().addDollar()).addDot()).addId()).addDollar()).build());
    return re.interpret(ctx);
  }

  private Context getContext(Map param)
  {
    Context c = null;
    try
    {
      String str = ((GenConfBuilder)((GenConfBuilder)(new GenConfBuilder()).addXmlFilePre()).addOtherValue((String)param.get(ExpressionEnum.fileName.getExpr()))).build();
      c = Context.getInstance(str);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return c;
  }

  private void parseModuleId(ModuleConfModel mcm, Context c)
  {
    c.init();
    ReadXmlExpression re = Parser.parse(((ModuleGenConfBuilder)((ModuleGenConfBuilder)(new ModuleGenConfBuilder()).addModuleGenConf().addDot()).addId()).build());
    String ss[] = re.interpret(c);
    mcm.setModuleId(ss[0]);
  }

  private Map parseNeedGenTypes(Context ctx)
  {
    ctx.init();
    Map map = new HashMap();
    ReadXmlExpression re = Parser.parse(((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)(new ModuleGenConfBuilder()).addModuleGenConf().addSeparator()).addNeedGenTypes().addSeparator()).addNeedGenType().addDollar()).addDot()).addId()).addDollar()).build());
    String needGenTypes[] = re.interpret(ctx);
    String as[];
    int j = (as = needGenTypes).length;
    for (int i = 0; i < j; i++)
    {
      String s = as[i];
      map.put(s, parseNeedGenOutTypes(ctx, s));
    }

    return map;
  }

  private List parseNeedGenOutTypes(Context ctx, String needGenId)
  {
    ctx.init();
    List list = new ArrayList();
    ReadXmlExpression re = Parser.parse(((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)((ModuleGenConfBuilder)(new ModuleGenConfBuilder()).addModuleGenConf().addSeparator()).addNeedGenTypes().addSeparator()).addNeedGenType().addDollar()).addOpenBracket()).addId()).addEqual()).addOtherValue(needGenId)).addCloseBracket()).addSeparator()).addNeedGenOutType().addDollar()).addDot()).addId()).addDollar()).build());
    String ss[] = re.interpret(ctx);
    String as[];
    int j = (as = ss).length;
    for (int i = 0; i < j; i++)
    {
      String s = as[i];
      list.add(s);
    }

    return list;
  }
}