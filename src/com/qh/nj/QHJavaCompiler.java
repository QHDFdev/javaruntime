package com.qh.nj;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;


//import net.openhft.compiler.CompilerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class QHJavaCompiler {
		
	private static final Logger logger = LoggerFactory.getLogger(QHJavaCompiler.class);
	long start;
	
	public CompileResult compile(File javaSourceFile, JavaCompileConfig config) {
		start = System.nanoTime();
		
		logger.debug("compile java file [{}] to [{}]", javaSourceFile.getAbsolutePath(), config.getDestPath());
		logger.debug("parent path: {}", javaSourceFile.getParent());
		
		mark("log Time ");
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();  
        mark("get compile Time ");
        JavaByteCodeManager javaByteCodeManager = new JavaByteCodeManager();
        mark("get codemanager Time ");
        MemoryJavaFileManager javaFileManager = (MemoryJavaFileManager) JavaFileManagerFactory.getMemoryJavaFileManager(config, javaCompiler);  
        mark("get Filemanager Time ");
        javaFileManager.setBytecodeManager(javaByteCodeManager);
       // mark("get codemanager Time ");
        // get all the JavaFileObject from src to be compiled
        Iterable<? extends JavaFileObject> it = javaFileManager.getJavaFileObjects(javaSourceFile);  
        
        
        mark("Prepare Time ");
        CompilationTask task = javaCompiler.getTask(null, javaFileManager, config.getInfoCollector(), 
        		Arrays.asList("-d", config.getDestPath(), "-sourcepath", this.getSourcePath(javaSourceFile)), 
        		null, it);  
        
        
        boolean compileResult = task.call();  
        mark("Compile Time ");
        
        CompileResult reuslt = new CompileResult(compileResult);
        reuslt.setJavaByteCodeManager(javaByteCodeManager);
        
        try {
			javaFileManager.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
        return reuslt;
	}
	
	private String getSourcePath(File javaSourceFile) {
		return javaSourceFile.getParentFile().getParent();
	}
		
	private void mark(String str) {
		logger.debug("{} : {} s.", str, (System.nanoTime() - start) / 1e9);
		start = System.nanoTime();
	}
}
