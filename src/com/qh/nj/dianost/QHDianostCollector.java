package com.qh.nj.dianost;

import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;

public interface QHDianostCollector<S> extends DiagnosticListener<S> {
	public List<Diagnostic<? extends S>> getDiagnostics();
}
