package com.github.bjlhx15.xgen.geninvocation.state;


import com.github.bjlhx15.xgen.geninvocation.DefaultGenInvocation;
import com.github.bjlhx15.xgen.mediator.CoreMediator;
import com.github.bjlhx15.xgen.template.TemplateEbi;

public class OutState
  implements State
{
  public void doWork(DefaultGenInvocation ctx) {
    CoreMediator.getInstance().registerObservers(ctx);


    ctx.setContentOver(((TemplateEbi)ctx.getTempContent()).getNowContent());
  }
}