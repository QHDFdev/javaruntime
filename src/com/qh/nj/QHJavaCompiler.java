package com.qh.nj;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.qh.nj.dianost.NormalDianostCollector;
import com.qh.nj.dianost.QHDianostCollector;


//import net.openhft.compiler.CompilerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class QHJavaCompiler {
	
	
	// compiler info collector
	QHDianostCollector infolistener = 	new NormalDianostCollector ();
	
	JavaByteCodeManager byteCodeManager;
	
	private static final Logger logger = LoggerFactory.getLogger(QHJavaCompiler.class);
	
	
	public boolean compile(File javaSourceFile, JavaCompileConfig config) {
		logger.debug("compile java file [{}] to [{}]", javaSourceFile.getAbsolutePath(), config.getDestPath());
		logger.debug("parent path: {}", javaSourceFile.getParent());
		
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();  
        
        StandardJavaFileManager javaFileManager = new QHJavaFileManager(javaCompiler.getStandardFileManager(infolistener, null, config.getCharset()));  
        
        // get all the JavaFileObject from src to be compiled
        Iterable<? extends JavaFileObject> it = javaFileManager.getJavaFileObjects(javaSourceFile);  
       
        CompilationTask task = javaCompiler.getTask(null, javaFileManager, infolistener, 
        		Arrays.asList("-d", config.getDestPath(), "-sourcepath", this.getSourcePath(javaSourceFile)), 
        		null, it);  
        
        boolean compileResult = task.call();  
        if(compileResult) {
        	//javaFileManager.ge
        }
        
        try {
			javaFileManager.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
        return compileResult;
	}
	
	private String getSourcePath(File javaSourceFile) {
		return javaSourceFile.getParentFile().getParent();
	}
	
	
	private void loadclass() {
		ClassLoader cloader = Thread.currentThread().getContextClassLoader();
		
	}
	
	
}
