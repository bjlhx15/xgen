package com.github.bjlhx15.xgen.dispatch;

import com.github.bjlhx15.xgen.dispatch.command.CmdInvoker;
import com.github.bjlhx15.xgen.dispatch.command.DefaultCommand;
import com.github.bjlhx15.xgen.genconf.implementors.GenConfImplementor;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.mediator.CoreMediator;

public class GenFacade {
    public static void generate() {
        generate(CoreMediator.getInstance().getDefaultGenConfProvider());
    }


    public static void generate(GenConfImplementor provider) {
        for (ModuleConfModel mcm : CoreMediator.getInstance().getNeedGenModuleConf(provider)) {
            genOneModule(mcm);
        }
    }


    private static void genOneModule(ModuleConfModel mcm) {
        DefaultCommand defaultCommand = new DefaultCommand(mcm);

        CmdInvoker invoker = new CmdInvoker();

        invoker.setCmd(defaultCommand);


        invoker.doCommand();
    }
}