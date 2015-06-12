package com.qh.nj;
/**
 * ÔËÐÐÈÝÆ÷
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
