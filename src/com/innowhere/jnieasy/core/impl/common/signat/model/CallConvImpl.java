/*
 * CallConvImpl.java
 *
 * Created on 1 de diciembre de 2004, 21:14
 */

package com.innowhere.jnieasy.core.impl.common.signat.model;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.typedec.CallConv;
import com.innowhere.jnieasy.core.impl.common.typedec.model.*;

public class CallConvImpl
{
    
    /** Creates a new instance of CallConvImpl */
    public CallConvImpl()
    {
    }
    
    public static void checkCallConvention(int callConv)
    {
        if ((callConv != CallConv.STD_CALL) &&
            (callConv != CallConv.C_CALL))
            throw new JNIEasyException("Bad call convention code");
    }    


}
