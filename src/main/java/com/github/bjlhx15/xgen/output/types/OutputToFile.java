package com.github.bjlhx15.xgen.output.types;

import com.github.bjlhx15.xgen.mediator.CoreMediator;
import com.github.bjlhx15.xgen.output.GenOutputEbi;
import com.github.bjlhx15.xgen.output.types.outputtofile.AbstractFactory;
import com.github.bjlhx15.xgen.output.types.outputtofile.plaintxt.PlainTxtFactory;

import java.util.Observable;


public class OutputToFile
        implements GenOutputEbi
{

    public OutputToFile()
    {
    }

    public void update(Observable o, Object obj)
    {
        String content = (new StringBuilder()).append(obj).toString();
        AbstractFactory af = new PlainTxtFactory();
        af.createGenOutPathPackages().genPackages(CoreMediator.getInstance().getObserverModuleConf(o), CoreMediator.getInstance().getObserverGenTypeId(o));
        String outPathAndFileName = af.createGenOutPathPackages().getOutPathAndFileName(CoreMediator.getInstance().getObserverModuleConf(o), CoreMediator.getInstance().getObserverGenTypeId(o));
        af.createOutter().writeContent(outPathAndFileName, content);
    }
}