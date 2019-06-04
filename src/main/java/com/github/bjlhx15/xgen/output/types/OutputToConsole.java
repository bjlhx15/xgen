package com.github.bjlhx15.xgen.output.types;

import com.github.bjlhx15.xgen.output.GenOutputEbi;
import java.util.Observable;


public class OutputToConsole
  implements GenOutputEbi
{
  public void update(Observable o, Object obj) {
    Object object = obj;

    System.out.println("now Content=" + object);
  }
}