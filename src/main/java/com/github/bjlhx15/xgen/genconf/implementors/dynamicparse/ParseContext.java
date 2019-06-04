package com.github.bjlhx15.xgen.genconf.implementors.dynamicparse;

import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.GenConfModel;

import java.util.Iterator;
import java.util.Map;


public class ParseContext
{

    public ParseContext()
    {
    }

    public Map parse(GenConfModel gm, Map mapEcms)
    {
        String key;
        ExtendConfModel ecm;
        for (Iterator iterator = mapEcms.keySet().iterator(); iterator.hasNext(); mapEcms.put(key, ecm))
        {
            key = (String)iterator.next();
            ecm = (ExtendConfModel)mapEcms.get(key);
            ecm.setValue(parseOne(gm, mapEcms, ecm.getValue()));
        }

        return mapEcms;
    }

    private String parseOne(GenConfModel gm, Map mapEcms, String value)
    {
        if (value != null && value.indexOf("${") >= 0)
        {
            int begin = value.indexOf("${");
            int end = begin + "${".length() + value.substring(begin + "${".length()).indexOf("}");
            String prop = value.substring(begin + "${".length(), end);
            ParseStrategy ps = null;
            if (isWord(prop))
                ps = new PropertyReplaceStrategy();
            else
                ps = new BeanShellStrategy();
            String tempStr = ps.parseDynamicContent(gm, mapEcms, prop);
            value = value.replace((new StringBuilder("${")).append(prop).append("}").toString(), tempStr);
            value = parseOne(gm, mapEcms, value);
        }
        return value;
    }

    private boolean isWord(String s)
    {
        char cs[] = s.toCharArray();
        char ac[];
        int j = (ac = cs).length;
        for (int i = 0; i < j; i++)
        {
            char c = ac[i];
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))
                return false;
        }

        return true;
    }
}