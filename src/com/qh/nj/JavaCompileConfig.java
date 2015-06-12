package com.qh.nj;

import java.nio.charset.Charset;

import com.qh.nj.dianost.NormalDianostCollector;
import com.qh.nj.dianost.QHDianostCollector;

public class JavaCompileConfig {
	public static final Charset qhdf_DEFAULT_CHAR_SET = Charset.forName("UTF-8");
	
	private QHDianostCollector infoCollector;
	
	private String destPath;
	
	private String sourcePath;
	
	private String classPath;
	
	
	public JavaCompileConfig() {
		infoCollector = new NormalDianostCollector();
	}
	
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

	public QHDianostCollector getInfoCollector() {
		return infoCollector;
	}

	public void setInfoCollector(QHDianostCollector infoCollector) {
		this.infoCollector = infoCollector;
	}
	
	
}
