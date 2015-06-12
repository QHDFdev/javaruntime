package com.qh.nj;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class CompileFileCache {
	/**
	 * 
	 */
	private static final Map<ClassLoader, Map<String, Class>> loadedClassesCache = new WeakHashMap<ClassLoader, Map<String, Class>>();
	
	
	public Class getClass(ClassLoader classloader, String classname) {
		 Map<String, Class> loadedClasses = null;
		 Class clazz = null;
	     synchronized (loadedClassesCache) {
            loadedClasses = loadedClassesCache.get(classloader);
            if (loadedClasses == null)
            	loadedClassesCache.put(classloader, loadedClasses = new LinkedHashMap<String, Class>());
            else
                clazz = loadedClasses.get(classname);
        }
	     return clazz;
	}
	
}
