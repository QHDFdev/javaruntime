package com.qh.nj.javaobject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

import com.qh.nj.JavaByteCodeManager;

/**
 * 
  * <p>Title: BufferJavaFileObject.java</p>
  * <p>Description: </p>
  * <p>Copyright: Copyright (c) 2015</p>
  * <p>Company: ABC-DE</p>
  * @author jzs
  * @date 2015Äê6ÔÂ12ÈÕ
  * @version 1.0
 */
public class BufferJavaFileObject extends SimpleJavaFileObject  {
	protected ByteArrayOutputStream bos;
	private JavaByteCodeManager jcm;
	private String classname;
	
	public BufferJavaFileObject(String name, Kind kind, JavaByteCodeManager jcm) {
		super(URI.create("string:///" + name.replace('.', '/')
	            + kind.extension), kind);
		this.jcm = jcm;
		this.classname = name;
	}
	
		
    @Override
    public OutputStream openOutputStream() throws IOException {
    	bos = jcm.registerJavaByteCodeObject(this.classname);
        return bos; 
    }
}
