package com.github.bjlhx15.xgen.genconf.implementors.xmlimpl;


import com.github.bjlhx15.xgen.genconf.constants.GenConfEnum;

public class GenConfBuilder
        extends CommonBuilder<GenConfBuilder> {
    private StringBuffer buffer = new StringBuffer();


    public GenConfBuilder addGenConf() {
        this.buffer.append(GenConfEnum.GenConf);
        return this;
    }

    public GenConfBuilder addNeedGens() {
        this.buffer.append(GenConfEnum.NeedGens);
        return this;
    }

    public GenConfBuilder addNeedGen() {
        this.buffer.append(GenConfEnum.NeedGen);
        return this;
    }

    public GenConfBuilder addThemes() {
        this.buffer.append(GenConfEnum.Themes);
        return this;
    }

    public GenConfBuilder addTheme() {
        this.buffer.append(GenConfEnum.Theme);
        return this;
    }

    public GenConfBuilder addConstants() {
        this.buffer.append(GenConfEnum.Constants);
        return this;
    }

    public GenConfBuilder addConstant() {
        this.buffer.append(GenConfEnum.Constant);
        return this;
    }

    public GenConfBuilder addProvider() {
        this.buffer.append(GenConfEnum.provider);
        return this;
    }

    public GenConfBuilder addThemeId() {
        this.buffer.append(GenConfEnum.themeId);
        return this;
    }

    public GenConfBuilder addParams() {
        this.buffer.append(GenConfEnum.Params);
        return this;
    }

    public GenConfBuilder addParam() {
        this.buffer.append(GenConfEnum.Param);
        return this;
    }


    protected StringBuffer getBuilderBuffer() {
        return this.buffer;
    }


    protected GenConfBuilder getBuilderClassInstance() {
        return this;
    }
}