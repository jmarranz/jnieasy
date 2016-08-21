/*
 * DLLInterfaceGenerator.java
 *
 * Created on 26 de marzo de 2004, 18:39
 */

package com.innowhere.jnieasy.core.impl.codegen.render.classdesc;

/**
 *
 * @author  jmarranz
 */
import java.util.*;
import java.io.*;

import com.innowhere.jnieasy.core.impl.util.*;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.FileCodeGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.Generator;



public class GeneratorRender
{
    protected Generator generator;
    
    /** Creates a new instance of DLLInterfaceGenerator */
    protected GeneratorRender(Generator generator)
    {
        this.generator = generator;
    }

    public static GeneratorRender newGeneratorRender(Generator generator)
    {
        return new GeneratorRender(generator);
    }
    
    public Generator getGenerator()
    {
        return generator;
    }

    public void generate()
    {
        for(Iterator it = generator.getIncludes().iterator(); it.hasNext(); )
        {
            Generator gen = (Generator)it.next();
            
            GeneratorRender genRender = GeneratorRender.newGeneratorRender(gen);
            genRender.generate();
        }
        
        for(Iterator it = generator.getFiles().iterator(); it.hasNext(); )
        {
            FileCodeGen fileGen = (FileCodeGen)it.next();
            FileCodeGenRender fileGenRender = FileCodeGenRender.newFileCodeGenRender(fileGen);

            fileGenRender.generate();
        }        
    }
}
