package com.qh.nj;

public class JavaCompilerProxy {
	private static CompileFileCache cache = new CompileFileCache();
	
	private QHJavaCompiler realCompiler;
	
	public JavaCompilerProxy() {
		
	}
	
	
	public void useLib() {
		System.out.println("use lib!");
	}
	
	
}
