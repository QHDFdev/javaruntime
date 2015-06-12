package com.qh.nj;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.tools.JavaFileObject.Kind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaByteCodeManager {
	private final Map<String, ByteArrayOutputStream> buffers = new LinkedHashMap<String, ByteArrayOutputStream>();
	private static final Logger logger = LoggerFactory.getLogger(JavaByteCodeManager.class);
	private QHClassLoader cl;
	
	public JavaByteCodeManager() {
		cl = new QHClassLoader(Thread.currentThread().getContextClassLoader());
	}
	
	
	public ByteArrayOutputStream registerJavaByteCodeObject(String classname) {
		logger.debug("add BytecodeStream : {}", classname);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		buffers.put(classname, bos);
		return bos;
	}
	
	public void loadClass() throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class clazz = null;
		for (Map.Entry<String, ByteArrayOutputStream> entry : buffers.entrySet()) {
			clazz = cl.loadClass(entry.getKey(), entry.getValue());
		}
		StrategyContainer container = new StrategyContainer(clazz);
		container.invoke();
	}
	
}
