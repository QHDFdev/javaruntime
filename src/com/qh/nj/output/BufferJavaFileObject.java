package com.qh.nj.output;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

public class BufferJavaFileObject extends SimpleJavaFileObject  {
	protected final ByteArrayOutputStream bos = new ByteArrayOutputStream();
	
	
	protected BufferJavaFileObject(String name, Kind kind) {
		super(URI.create("string:///" + name.replace('.', '/')
	            + kind.extension), kind);
	}
	
    @Override
    public OutputStream openOutputStream() throws IOException {
        return bos;
    }
}
