package com.github.bjlhx15.xgen.genconf.implementors.xmlimpl;


import com.github.bjlhx15.xgen.genconf.constants.ModuleGenConfEnum;

public class ModuleGenConfBuilder
  extends CommonBuilder<ModuleGenConfBuilder>
{
  private StringBuffer buffer = new StringBuffer();

  public ModuleGenConfBuilder addModuleGenConf() {
    this.buffer.append(ModuleGenConfEnum.ModuleGenConf);
    return this;
  }
  public ModuleGenConfBuilder addNeedGenTypes() {
    this.buffer.append(ModuleGenConfEnum.NeedGenTypes);
    return this;
  }
  public ModuleGenConfBuilder addNeedGenType() {
    this.buffer.append(ModuleGenConfEnum.NeedGenType);
    return this;
  }
  public ModuleGenConfBuilder addNeedGenOutType() {
    this.buffer.append(ModuleGenConfEnum.NeedGenOutType);
    return this;
  }
  public ModuleGenConfBuilder addExtendConfs() {
    this.buffer.append(ModuleGenConfEnum.ExtendConfs);
    return this;
  }
  public ModuleGenConfBuilder addExtendConf() {
    this.buffer.append(ModuleGenConfEnum.ExtendConf);
    return this;
  }
  public ModuleGenConfBuilder addIsSingle() {
    this.buffer.append(ModuleGenConfEnum.isSingle);
    return this;
  }



  protected StringBuffer getBuilderBuffer() { return this.buffer; }



  protected ModuleGenConfBuilder getBuilderClassInstance() { return this; }
}