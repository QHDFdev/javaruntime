package test;


import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.junit.Test;

import com.qh.nj.CompileResult;
import com.qh.nj.JavaCompileConfig;
import com.qh.nj.QHJavaCompiler;

public class CompilerT {

	@Test
	public void test() throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		File src = new File("D:/Program/RemoteJavaRuntime/src/eg/test.java");
		QHJavaCompiler compiler = new QHJavaCompiler();
		JavaCompileConfig config = new JavaCompileConfig();
		config.setDestPath("D:/testpath");
		CompileResult result = compiler.compile(src, config);
		
		assertTrue(result.isSuccess());
		result.getJavaByteCodeManager().loadClass();
	}
	
	//@Test
	public void testFileManager() {
		JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();  
		StandardJavaFileManager m1 = javaCompiler.getStandardFileManager(null, null, null);
		StandardJavaFileManager m2 = javaCompiler.getStandardFileManager(null, null, null);
		assertTrue(m1 != m2);
	}
	
}
