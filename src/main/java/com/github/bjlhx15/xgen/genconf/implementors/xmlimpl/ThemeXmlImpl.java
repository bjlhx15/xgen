package com.github.bjlhx15.xgen.genconf.implementors.xmlimpl;

import com.github.bjlhx15.xgen.genconf.constants.ExpressionEnum;
import com.github.bjlhx15.xgen.genconf.implementors.ThemeImplementer;
import com.github.bjlhx15.xgen.genconf.vo.GenTypeModel;
import com.github.bjlhx15.xgen.util.readxml.Context;
import com.github.bjlhx15.xgen.util.readxml.Parser;
import com.github.bjlhx15.xgen.util.readxml.ReadXmlExpression;

import java.util.HashMap;
import java.util.Map;


public class ThemeXmlImpl
        implements ThemeImplementer {
    public Map<String, GenTypeModel> getMapGenTypes(String themeId, Map<String, String> param) {
        Map<String, GenTypeModel> map = new HashMap<String, GenTypeModel>();

        String[] genTypeIds = parseGenTypeIds(getContext(param));
        String[] genTypeValues = parseGenTypeValues(getContext(param));

        for (int i = 0; i < genTypeIds.length; i++) {
            GenTypeModel gtm = new GenTypeModel();

            gtm.setGenTypeClass(genTypeValues[i]);
            gtm.setId(genTypeIds[i]);

            String[] paramIds = parseGenTypeParamIds(getContext(param), gtm.getId());
            String[] paramValues = parseGenTypeParamValues(getContext(param), gtm.getId());

            Map<String, String> paramMap = new HashMap<String, String>();
            for (int j = 0; j < paramIds.length; j++) {
                paramMap.put(paramIds[j], paramValues[j]);
            }

            gtm.setMapParams(paramMap);

            map.put(gtm.getId(), gtm);
        }
        return map;
    }


    public Map<String, String> getMapGenOutTypes(String themeId, Map<String, String> param) {
        Map<String, String> map = new HashMap<String, String>();

        String[] genOutTypeIds = parseOutTypeIds(getContext(param));
        String[] genOutTypeValues = parseOutTypeValues(getContext(param));

        for (int i = 0; i < genOutTypeIds.length; i++) {
            map.put(genOutTypeIds[i], genOutTypeValues[i]);
        }

        return map;
    }


    public Map<String, String> getMapProviders(String themeId, Map<String, String> param) {
        Map<String, String> map = new HashMap<String, String>();

        String[] genProviderIds = parseProviderIds(getContext(param));
        String[] genProviderValues = parseProviderValues(getContext(param));

        for (int i = 0; i < genProviderIds.length; i++) {
            map.put(genProviderIds[i], genProviderValues[i]);
        }

        return map;
    }

    private Context getContext(Map<String, String> param) {
        Context c = null;
        try {
            c = Context.getInstance(
                    String.valueOf((String) param.get(ExpressionEnum.location.getExpr())) +
                            ExpressionEnum.separator.getExpr() +
                            ExpressionEnum.themeXmlName.getExpr());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    private String[] parseGenTypeParamValues(Context c, String genTypeId) {
        c.init();
        ReadXmlExpression re = Parser.parse((
                (ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder()).addTheme().addSeparator())
                        .addGenTypes().addSeparator()).addGenType().addDollar())
                        .addOpenBracket()).addId()).addEqual()).addOtherValue(genTypeId)).addCloseBracket()).addSeparator())
                        .addParams().addSeparator())
                        .addParam().addDollar())
                .build());

        return re.interpret(c);
    }

    private String[] parseGenTypeParamIds(Context c, String genTypeId) {
        c.init();
        ReadXmlExpression re = Parser.parse((
                (ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder()).addTheme().addSeparator())
                        .addGenTypes().addSeparator()).addGenType().addDollar())
                        .addOpenBracket()).addId()).addEqual()).addOtherValue(genTypeId)).addCloseBracket()).addSeparator())
                        .addParams().addSeparator())
                        .addParam().addDollar())
                        .addDot()).addId()).addDollar())
                .build());

        return re.interpret(c);
    }

    private String[] parseGenTypeValues(Context c) {
        c.init();
        ReadXmlExpression re = Parser.parse((
                (ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder()).addTheme().addSeparator())
                        .addGenTypes().addSeparator()).addGenType().addDollar())
                        .addDot()).addType().addDollar())
                .build());

        return re.interpret(c);
    }

    private String[] parseGenTypeIds(Context c) {
        c.init();
        ReadXmlExpression re = Parser.parse((
                (ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder()).addTheme().addSeparator())
                        .addGenTypes().addSeparator()).addGenType().addDollar())
                        .addDot()).addId()).addDollar())
                .build());

        return re.interpret(c);
    }

    private String[] parseOutTypeValues(Context c) {
        c.init();
        ReadXmlExpression re = Parser.parse((
                (ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder()).addTheme().addSeparator())
                        .addGenOutTypes().addSeparator()).addGenOutType().addDollar())
                        .addDot()).addType().addDollar())
                .build());

        return re.interpret(c);
    }

    private String[] parseOutTypeIds(Context c) {
        c.init();
        ReadXmlExpression re = Parser.parse((
                (ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder()).addTheme().addSeparator())
                        .addGenOutTypes().addSeparator()).addGenOutType().addDollar())
                        .addDot()).addId()).addDollar())
                .build());

        return re.interpret(c);
    }

    private String[] parseProviderValues(Context c) {
        c.init();
        ReadXmlExpression re = Parser.parse((
                (ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder()).addTheme().addSeparator())
                        .addProviders().addSeparator()).addProvider().addDollar())
                        .addDot()).addType().addDollar())
                .build());

        return re.interpret(c);
    }

    private String[] parseProviderIds(Context c) {
        c.init();
        ReadXmlExpression re = Parser.parse((
                (ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) ((ThemeBuilder) (new ThemeBuilder()).addTheme().addSeparator())
                        .addProviders().addSeparator()).addProvider().addDollar())
                        .addDot()).addId()).addDollar())
                .build());

        return re.interpret(c);
    }
}