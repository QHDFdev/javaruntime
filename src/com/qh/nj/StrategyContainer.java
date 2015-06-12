package com.qh.nj;

import java.io.IOException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ÔËÐÐÈÝÆ÷
 * @author Administrator
 *
 */
public class StrategyContainer {
	private static final Logger logger = LoggerFactory.getLogger(StrategyContainer.class);
	Class clazz;
	
	public StrategyContainer(Class clazz) {
		this.clazz = clazz;
	}
	
	
	private void loadClass() {
		
	}
	
	public void invoke() {
		Object o;
		try {
			o = clazz.newInstance();
			invokeMethod(o, "main", (Object) new String[]{});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private  void invokeMethod(Object ins, String methodName, Object... object) {
		try {
			logger.debug("Invoke: {}.{}({})", ins.getClass().getName(), methodName, object);
			Class types[] = new Class[object.length];
			for(int i = 0 ; i < object.length; i ++) {
				types[i] = object[i].getClass();
			}
			
			Method m = clazz.getMethod("main",types );
			m.invoke(ins, object);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
