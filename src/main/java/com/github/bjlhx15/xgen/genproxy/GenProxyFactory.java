package com.github.bjlhx15.xgen.genproxy;


import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.geninvocation.GenInvocation;
import com.github.bjlhx15.xgen.mediator.CoreMediator;

public class GenProxyFactory
{
  public static GenInvocation createGenProxy(String needGenType, ModuleConfModel moduleConf) {
    GenInvocation invocation = CoreMediator.getInstance().getDefaultGenInvocation(needGenType, moduleConf);


    return new DefaultProxy(invocation);
  }
}