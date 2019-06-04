package com.github.bjlhx15.xgen.util.readxml;

public class ParseCaretaker {
  private static ParseCaretaker taker = new ParseCaretaker();
  private ParseMemento memento = null;





  public static ParseCaretaker getInstance() { return taker; }




  public void saveMemento(ParseMemento memento) { this.memento = memento; }


  public ParseMemento retriveMemento() { return this.memento; }
}