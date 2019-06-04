package com.github.bjlhx15.xgen.dispatch.executechain;

import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.mediator.CoreMediator;

public class DefaultHandler
  extends GenHandler
{
  private String needGenType = "";


  public DefaultHandler(String needGenType) { this.needGenType = needGenType; }



  public void handleRequest(ModuleConfModel mcm) {
    CoreMediator.getInstance().needProxyGen(this.needGenType, mcm);


    super.handleRequest(mcm);
  }
}