package com.github.bjlhx15.xgen.output.types.outputtofile.plaintxt;

import com.github.bjlhx15.xgen.output.types.outputtofile.AbstractFactory;
import com.github.bjlhx15.xgen.output.types.outputtofile.GenOutPathPackages;
import com.github.bjlhx15.xgen.output.types.outputtofile.Outter;


public class PlainTxtFactory
  implements AbstractFactory
{
  public GenOutPathPackages createGenOutPathPackages() { return new GenOutPathPackageImpl(); }




  public Outter createOutter() { return new OutterImpl(); }
}