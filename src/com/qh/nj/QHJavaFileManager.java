package com.qh.nj;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.tools.FileObject;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.StandardJavaFileManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QHJavaFileManager implements StandardJavaFileManager {
	private StandardJavaFileManager fileManager;
	private JavaByteCodeManager bytecodeManager;
	private static final Logger logger = LoggerFactory.getLogger(QHJavaFileManager.class);
	
	
	
	public QHJavaFileManager(StandardJavaFileManager f) {
		logger.debug("StandardJavaFileManager: {}", f.getClass());
		fileManager = f;
	}
	
	
	

	@Override
	public int isSupportedOption(String option) {
		return fileManager.isSupportedOption(option);
	}

	@Override
	public ClassLoader getClassLoader(Location location) {
		return fileManager.getClassLoader(location);
	}

	@Override
	public Iterable<JavaFileObject> list(Location location, String packageName,
			Set<Kind> kinds, boolean recurse) throws IOException {
		return fileManager.list(location, packageName, kinds, recurse);
	}

	@Override
	public String inferBinaryName(Location location, JavaFileObject file) {
		return fileManager.inferBinaryName(location, file);
	}

	@Override
	public boolean isSameFile(FileObject a, FileObject b) {
		return fileManager.isSameFile(a, b);
	}

	@Override
	public boolean handleOption(String current, Iterator<String> remaining) {
		return fileManager.handleOption(current, remaining);
	}

	@Override
	public boolean hasLocation(Location location) {
		return fileManager.hasLocation(location);
	}

	@Override
	public JavaFileObject getJavaFileForInput(Location location,
			String className, Kind kind) throws IOException {
		return fileManager.getJavaFileForInput(location, className, kind);
	}

	@Override
	public JavaFileObject getJavaFileForOutput(Location location,
			String className, Kind kind, FileObject sibling) throws IOException {
		
		logger.debug("Output Java File: {}, {}, {}", location.getName(), className, kind.name());
		return fileManager.getJavaFileForOutput(location, className, kind, sibling);
	}

	@Override
	public FileObject getFileForInput(Location location, String packageName,
			String relativeName) throws IOException {
		return fileManager.getFileForInput(location, packageName, relativeName);
	}

	@Override
	public FileObject getFileForOutput(Location location, String packageName,
			String relativeName, FileObject sibling) throws IOException {
		return fileManager.getFileForOutput(location, packageName, relativeName, sibling);
	}

	@Override
	public void flush() throws IOException {
		fileManager.flush();
	}

	@Override
	public void close() throws IOException {
		fileManager.close();
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

}
