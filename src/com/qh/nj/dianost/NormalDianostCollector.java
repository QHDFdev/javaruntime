package com.qh.nj.dianost;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.tools.Diagnostic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qh.nj.QHJavaCompiler;

public class NormalDianostCollector<S> implements QHDianostCollector<S> {
	private static final Logger logger = LoggerFactory.getLogger(QHDianostCollector.class);
	private List<Diagnostic<? extends S>> diagnostics =
		        Collections.synchronizedList(new ArrayList<Diagnostic<? extends S>>());

    public void report(Diagnostic<? extends S> diagnostic) {
        diagnostic.getClass(); // null check
        logger.debug(diagnostic.getMessage(null) + " " +  diagnostic.getLineNumber());
        diagnostics.add(diagnostic);
        
    }

    /**
     * Gets a list view of diagnostics collected by this object.
     *
     * @return a list view of diagnostics
     */
    @Override
    public List<Diagnostic<? extends S>> getDiagnostics() {
        return Collections.unmodifiableList(diagnostics);
    }

	

}
