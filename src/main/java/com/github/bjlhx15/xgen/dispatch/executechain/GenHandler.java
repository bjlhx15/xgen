package com.github.bjlhx15.xgen.dispatch.executechain;

import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;

public abstract class GenHandler {
    protected GenHandler successor;

    public void setSuccessor(GenHandler successor) {
        this.successor = successor;
    }


    public void handleRequest(ModuleConfModel mcm) {
        if (this.successor != null)
            this.successor.handleRequest(mcm);
    }
}