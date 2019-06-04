package com.github.bjlhx15.xgen.genproxy;


import com.github.bjlhx15.xgen.geninvocation.GenInvocation;

public class DefaultProxy
        implements GenInvocation {
    private GenInvocation invocation = null;


    public DefaultProxy(GenInvocation invocation) {
        this.invocation = invocation;
    }


    public void executeGen() {
        this.invocation.executeGen();
    }
}