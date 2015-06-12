package com.qh.nj;

public class CompileResult {
	private JavaByteCodeManager javaByteCodeManager;
	private boolean result;
	
	public CompileResult(boolean r) {
		this.result = r;
	}
	
	public boolean isSuccess() {
		return result;
	}

	public JavaByteCodeManager getJavaByteCodeManager() {
		return javaByteCodeManager;
	}

	public void setJavaByteCodeManager(JavaByteCodeManager javaByteCodeManager) {
		this.javaByteCodeManager = javaByteCodeManager;
	}
	
}
