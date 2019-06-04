package com.github.bjlhx15.xgen.util.readxml;















public class ParseModel
{
  private String eleName;
  private boolean propertyValue;
  private boolean end;
  private boolean singleValue;
  private String condition;

  public String getEleName() { return this.eleName; }


  public void setEleName(String eleName) { this.eleName = eleName; }


  public boolean isPropertyValue() { return this.propertyValue; }


  public void setPropertyValue(boolean propertyValue) { this.propertyValue = propertyValue; }


  public boolean isEnd() { return this.end; }


  public void setEnd(boolean end) { this.end = end; }


  public boolean isSingleValue() { return this.singleValue; }


  public void setSingleValue(boolean singleValue) { this.singleValue = singleValue; }


  public String getCondition() { return this.condition; }


  public void setCondition(String condition) { this.condition = condition; }


  public String toString() {
    return "ParseModel [eleName=" + this.eleName + ", propertyValue=" +
      this.propertyValue + ", end=" + this.end + ", singleValue=" +
      this.singleValue + ", condition=" + this.condition + "]";
  }
}