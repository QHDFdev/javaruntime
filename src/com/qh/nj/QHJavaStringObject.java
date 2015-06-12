package com.qh.nj;

import java.net.URI;

import javax.tools.SimpleJavaFileObject;

/**
 * Java源代码文件抽象类
 * @author JZS
 *
 */
public class QHJavaStringObject extends SimpleJavaFileObject {
	
	
	private final String code;
	
	/**
	 * 初始化
	 * @param name 完整类名，包括包名
	 * @param code 完整代码串
	 */
	private QHJavaStringObject(String name, String code) {
	   super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension),
	                Kind.SOURCE);
	  
	   this.code = code;
	}
	
	
	public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }
	//private QHJavaStringObject(URI uri, Kind kind) {
	//	super(uri, kind);
	//}
		
}
