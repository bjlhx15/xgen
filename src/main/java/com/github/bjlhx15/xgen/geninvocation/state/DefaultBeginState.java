package com.github.bjlhx15.xgen.geninvocation.state;

import com.github.bjlhx15.xgen.geninvocation.DefaultGenInvocation;

public class DefaultBeginState
        implements State {
    public void doWork(DefaultGenInvocation ctx) {
        ctx.setState(new GenState());
        ctx.doWork();
    }
}