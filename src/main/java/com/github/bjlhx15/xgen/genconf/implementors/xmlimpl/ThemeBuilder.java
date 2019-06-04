package com.github.bjlhx15.xgen.genconf.implementors.xmlimpl;

import com.github.bjlhx15.xgen.genconf.constants.ThemeEnum;


public class ThemeBuilder
  extends CommonBuilder<ThemeBuilder>
{
  private StringBuffer buffer = new StringBuffer();


  public ThemeBuilder addTheme() {
    this.buffer.append(ThemeEnum.Theme);
    return this;
  }
  public ThemeBuilder addGenTypes() {
    this.buffer.append(ThemeEnum.GenTypes);
    return this;
  }
  public ThemeBuilder addGenType() {
    this.buffer.append(ThemeEnum.GenType);
    return this;
  }
  public ThemeBuilder addParams() {
    this.buffer.append(ThemeEnum.Params);
    return this;
  }
  public ThemeBuilder addParam() {
    this.buffer.append(ThemeEnum.Param);
    return this;
  }
  public ThemeBuilder addGenOutTypes() {
    this.buffer.append(ThemeEnum.GenOutTypes);
    return this;
  }
  public ThemeBuilder addGenOutType() {
    this.buffer.append(ThemeEnum.GenOutType);
    return this;
  }
  public ThemeBuilder addProviders() {
    this.buffer.append(ThemeEnum.Providers);
    return this;
  }
  public ThemeBuilder addProvider() {
    this.buffer.append(ThemeEnum.Provider);
    return this;
  }
  public ThemeBuilder addType() {
    this.buffer.append(ThemeEnum.type);
    return this;
  }




  protected StringBuffer getBuilderBuffer() { return this.buffer; }



  protected ThemeBuilder getBuilderClassInstance() { return this; }
}