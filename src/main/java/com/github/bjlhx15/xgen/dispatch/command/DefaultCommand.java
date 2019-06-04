package com.github.bjlhx15.xgen.dispatch.command;

import com.github.bjlhx15.xgen.dispatch.executechain.DefaultHandler;
import com.github.bjlhx15.xgen.dispatch.executechain.GenHandler;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DefaultCommand
        implements GenCommand {
    private ModuleConfModel moduleConf;

    public DefaultCommand(ModuleConfModel moduleConf) {
        this.moduleConf = moduleConf;
    }


    public void execute() {
        List<String> listNeedGenTypes = new ArrayList<String>();

        for (String s : this.moduleConf.getMapNeedGendTypes().keySet()) {
            listNeedGenTypes.add(s);
        }


        Map<Integer, GenHandler> mapHandler = new HashMap<Integer, GenHandler>();
        for (int i = 0; i < listNeedGenTypes.size(); i++) {
            mapHandler.put(Integer.valueOf(i + 1), new DefaultHandler((String) listNeedGenTypes.get(i)));
        }

        GenHandler h1 = (GenHandler) mapHandler.get(Integer.valueOf(1));
        for (int i = 1; i < mapHandler.values().size(); i++) {
            ((GenHandler) mapHandler.get(Integer.valueOf(i))).setSuccessor((GenHandler) mapHandler.get(Integer.valueOf(i + 1)));
        }


        h1.handleRequest(this.moduleConf);
    }
}