package com.qh.nj;

import java.net.URI;

import javax.tools.SimpleJavaFileObject;

/**
 * JavaԴ�����ļ�������
 * @author JZS
 *
 */
public class QHJavaStringObject extends SimpleJavaFileObject {
	
	
	private final String code;
	
	/**
	 * ��ʼ��
	 * @param name ������������������
	 * @param code �������봮
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
