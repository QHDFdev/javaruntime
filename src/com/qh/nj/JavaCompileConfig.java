package com.qh.nj;

import java.nio.charset.Charset;

public class JavaCompileConfig {
	public static final Charset qhdf_DEFAULT_CHAR_SET = Charset.forName("UTF-8");
	
	private String destPath;
	
	private String sourcePath;
	
	
	public Charset getCharset() {
		return qhdf_DEFAULT_CHAR_SET;
	}




	public String getDestPath() {
		return destPath;
	}




	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}




	public String getSourcePath() {
		return sourcePath;
	}




	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}
	
	
}
