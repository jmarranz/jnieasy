/*
 * BehaviorOfClassGen.java
 *
 * Created on 28 de febrero de 2005, 20:35
 */

package com.innowhere.jnieasy.core.impl.codegen.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.BehaviorOfClassImpl;
import com.innowhere.jnieasy.core.impl.codegen.model.signat.NativeBehaviorSignatureGen;


public abstract class BehaviorOfClassGen extends MemberOfClassGen
{
    protected int index;
    protected NativeBehaviorSignatureGen signature;
            
    /** Creates a new instance of BehaviorOfClassGen */
    public BehaviorOfClassGen(BehaviorOfClassImpl accessObject,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        super(accessObject,classGen);
        
        this.signature = new NativeBehaviorSignatureGen(accessObject.getBehaviorSignature());
    }
    
    public NativeBehaviorSignatureGen getBehaviorSignatureGen()
    {
        return signature;
    }    
    
    public BehaviorOfClassImpl getBehaviorOfClass()
    {
        return (BehaviorOfClassImpl)accessObject;
    }
    
    /**
     * Getter for property index.
     * @return Value of property index.
     */
    public int getIndex()
    {
        return index;
    }
    
    /**
     * Setter for property index.
     * @param index New value of property index.
     */
    public void setIndex(int index)
    {
        this.index = index;
    }

}
