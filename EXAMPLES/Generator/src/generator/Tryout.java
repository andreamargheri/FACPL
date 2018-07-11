package generator;

import java.io.File;


public class Tryout {

	public static void main(String[] args) throws Exception {
		
		String pathFileToCompile = "EX-Source/alice.fpl";
		File file = new File(pathFileToCompile);
		String FileToCompile = file.getAbsolutePath();

		/* Java Code Generation */ 
		FacplGenerator.java_compile(new String[]{FileToCompile, "EX-Source/java"});
		
		/* XACML Code Generation */ 
		FacplGenerator.xml_compile(new String[]{FileToCompile, "EX-Source/xacml"});
		
		/* SMT-LIB Code Generation */ 
		FacplGenerator.compile_SMT_Complete(new String[]{FileToCompile, "EX-Source/smt"},1);
		

	}

}
