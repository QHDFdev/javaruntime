package com.qh.nj;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QHClassLoader extends URLClassLoader {
	private static final Logger logger = LoggerFactory.getLogger(URLClassLoader.class);
    public QHClassLoader(ClassLoader parent) {
        super(new URL[0], parent);
    }
 
    public Class findClassByClassName(String className) throws ClassNotFoundException {
        return this.findClass(className);
    }
    
    
    public Class loadClass(String fullName, ByteArrayOutputStream os) {
    	this.
    	logger.debug("try to load [{}]", fullName);
        byte[] classData = os.toByteArray();
        return this.defineClass(fullName, classData, 0, classData.length);
    }
}