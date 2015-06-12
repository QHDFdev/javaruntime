package com.qh.nj;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class JavaFileManagerFactory {
	
	//public static 
	
	
	public static StandardJavaFileManager getStandardFileManager(JavaCompileConfig config, JavaCompiler cmp) {
		return cmp.getStandardFileManager(config.getInfoCollector(), null, config.getCharset()); 
	}
	
	public static StandardJavaFileManager getMemoryJavaFileManager(JavaCompileConfig config, JavaCompiler cmp) {
		return new MemoryJavaFileManager(getStandardFileManager(config, cmp));  
	}
	
}
