package com.qh.nj;
/**
 * ��������
 * @author Administrator
 *
 */
public class StrategyContainer {
	ClassLoader cl;
	
	public StrategyContainer() {
		cl = Thread.currentThread().getContextClassLoader();
	}
	
	
	private void loadClass() {
		
	}
	
	
}
