package com.github.bjlhx15.xgen.geninvocation;

import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.geninvocation.state.DefaultBeginState;
import com.github.bjlhx15.xgen.geninvocation.state.State;

import java.util.Observable;

public class DefaultGenInvocation
  extends Observable
  implements GenInvocation {
  private State state = null;



  private String needGenType = "";




  private ModuleConfModel moduleConf;



  private Object tempContent = null;


  public DefaultGenInvocation(String needGenType, ModuleConfModel moduleConf) {
    this.needGenType = needGenType;
    this.moduleConf = moduleConf;
  }




  public void doWork() { this.state.doWork(this); }





  public void executeGen() {
    this.state = new DefaultBeginState();

    this.state.doWork(this);
  }







  public void setContentOver(Object obj) {
    setChanged();
    notifyObservers(obj);
  }



  public String getNeedGenType() { return this.needGenType; }


  public ModuleConfModel getModuleConf() { return this.moduleConf; }


  public void setState(State state) { this.state = state; }


  public Object getTempContent() { return this.tempContent; }


  public void setTempContent(Object tempContent) { this.tempContent = tempContent; }
}