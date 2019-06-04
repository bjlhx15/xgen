package com.github.bjlhx15.xgen.geninvocation;

import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;

public class GenInvocationFactory {
    public static GenInvocation createGenInvocation(String needGenType, ModuleConfModel moduleConf) {
        return new DefaultGenInvocation(needGenType, moduleConf);
    }
}