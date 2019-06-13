package com.github.bjlhx15.xgen.dispatch;

import com.github.bjlhx15.xgen.dispatch.command.CmdInvoker;
import com.github.bjlhx15.xgen.dispatch.command.DefaultCommand;
import com.github.bjlhx15.xgen.dispatch.command.GenCommand;
import com.github.bjlhx15.xgen.genconf.implementors.GenConfImplementor;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.mediator.CoreMediator;

import java.util.Iterator;

public class GenFacade {
    private GenFacade() {
    }

    public static void generate() {
        generate(CoreMediator.getInstance().getDefaultGenConfProvider());
    }

    public static void generate(GenConfImplementor provider) {
        ModuleConfModel mcm;
        for (Iterator iterator = CoreMediator.getInstance().getNeedGenModuleConf(provider).iterator(); iterator.hasNext(); genOneModule(mcm))
            mcm = (ModuleConfModel) iterator.next();

    }

    private static void genOneModule(ModuleConfModel mcm) {
        GenCommand cmd = new DefaultCommand(mcm);
        CmdInvoker invoker = new CmdInvoker();
        invoker.setCmd(cmd);
        invoker.doCommand();
    }
}