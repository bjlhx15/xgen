package com.github.bjlhx15.xgen.genconf.implementors.xmlimpl;


import com.github.bjlhx15.xgen.genconf.constants.ExpressionEnum;
import com.github.bjlhx15.xgen.genconf.constants.GenConfEnum;

public abstract class CommonBuilder<T>
        extends Object {
    protected abstract StringBuffer getBuilderBuffer();

    protected abstract T getBuilderClassInstance();

    public T addDot() {
        getBuilderBuffer().append(ExpressionEnum.dot.getExpr());
        return (T) getBuilderClassInstance();
    }


    public T addSeparator() {
        getBuilderBuffer().append(ExpressionEnum.separator.getExpr());
        return (T) getBuilderClassInstance();
    }


    public T addDollar() {
        getBuilderBuffer().append(ExpressionEnum.dollar.getExpr());
        return (T) getBuilderClassInstance();
    }


    public T addOpenBracket() {
        getBuilderBuffer().append(ExpressionEnum.openBracket.getExpr());
        return (T) getBuilderClassInstance();
    }


    public T addCloseBracket() {
        getBuilderBuffer().append(ExpressionEnum.closeBracket.getExpr());
        return (T) getBuilderClassInstance();
    }


    public T addEqual() {
        getBuilderBuffer().append(ExpressionEnum.equal.getExpr());
        return (T) getBuilderClassInstance();
    }


    public T addComma() {
        getBuilderBuffer().append(ExpressionEnum.comma.getExpr());
        return (T) getBuilderClassInstance();
    }


    public T addXml() {
        getBuilderBuffer().append(ExpressionEnum.xml.getExpr());
        return (T) getBuilderClassInstance();
    }


    public T addXmlFilePre() {
        getBuilderBuffer().append(ExpressionEnum.xmlFilePre.getExpr());
        return (T) getBuilderClassInstance();
    }


    public T addId() {
        getBuilderBuffer().append(GenConfEnum.id);
        return (T) getBuilderClassInstance();
    }


    public T addOtherValue(String value) {
        getBuilderBuffer().append(value);
        return (T) getBuilderClassInstance();
    }


    public String build() {
        return getBuilderBuffer().toString();
    }
}