package com.qh.nj;

import java.io.File;
import java.io.IOException;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.StandardJavaFileManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qh.nj.javaobject.BufferJavaFileObject;

public class MemoryJavaFileManager extends ForwardingJavaFileManager implements StandardJavaFileManager {
	private StandardJavaFileManager fileManager;
	private JavaByteCodeManager bytecodeManager;
	private static final Logger logger = LoggerFactory.getLogger(MemoryJavaFileManager.class);
	
	
	
	public MemoryJavaFileManager(StandardJavaFileManager f) {
		super(f);
		logger.debug("StandardJavaFileManager: {}", f.getClass());
		fileManager = f;
	}
	
	public JavaByteCodeManager getBytecodeManager() {
		return bytecodeManager;
	}

	public void setBytecodeManager(JavaByteCodeManager bytecodeManager) {
		this.bytecodeManager = bytecodeManager;
	}

	@Override
	public JavaFileObject getJavaFileForOutput(Location location,
			String className, Kind kind, FileObject sibling) throws IOException {	
		logger.debug("Output Java File: {}, {}, {}", location.getName(), className, kind.name());
		return  new BufferJavaFileObject(className, kind, bytecodeManager); 
	}

	
	@Override
	public Iterable<? extends JavaFileObject> getJavaFileObjectsFromStrings(
			Iterable<String> names) {
		return fileManager.getJavaFileObjectsFromStrings(names);
	}

	@Override
	public Iterable<? extends JavaFileObject> getJavaFileObjects(
			String... names) {
		return fileManager.getJavaFileObjects(names);
	}


	@Override
	public void setLocation(Location location, Iterable<? extends File> path)
			throws IOException {
		fileManager.setLocation(location, path);
	}

	@Override
	public Iterable<? extends File> getLocation(Location location) {
		return fileManager.getLocation(location);
	}


	@Override
	public Iterable<? extends JavaFileObject> getJavaFileObjectsFromFiles(
			Iterable<? extends File> files) {
		return fileManager.getJavaFileObjectsFromFiles(files);
	}

	@Override
	public Iterable<? extends JavaFileObject> getJavaFileObjects(File... files) {
		return fileManager.getJavaFileObjects(files);
	}

}
