package com.github.bjlhx15.xgen.geninvocation.state;


import com.github.bjlhx15.xgen.geninvocation.BaseGenAction;
import com.github.bjlhx15.xgen.geninvocation.DefaultGenInvocation;
import com.github.bjlhx15.xgen.mediator.CoreMediator;

public class GenState
        implements State {
    public void doWork(DefaultGenInvocation ctx) {
        String className = CoreMediator.getInstance().getNeedGenTypeClass(ctx.getNeedGenType(), ctx.getModuleConf());


        Object obj = null;

        try {
            obj = ((BaseGenAction) Class.forName(className).newInstance()).generate(ctx.getModuleConf());
        } catch (Exception e) {
            e.printStackTrace();
        }


        ctx.setTempContent(obj);


        ctx.setState(new OutState());
        ctx.doWork();
    }
}