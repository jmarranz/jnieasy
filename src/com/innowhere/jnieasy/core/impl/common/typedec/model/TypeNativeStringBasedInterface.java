/*
 * TypeNativeStringBasedInterface.java
 *
 * Created on 5 de enero de 2005, 20:17
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;

/**
 *
 * @author  jmarranz
 */

public interface TypeNativeStringBasedInterface extends TypeCanBeNativeCapableInterface
{
    public boolean isFixedEncoding();
    public int getDefaultEncoding();
    public boolean isValidEncoding(int encoding);   
    public String getEncodingExpr();
    public void setEncodingExpr(String encodingExpr);    
}
