package edu.soumya.maven.multimoduletest;

import java.util.Set;

public class CommonNModuleSignatureAdder {
	
	public static Set<String> addCommonNModuleSignature(String moduleName) {
		return new ModuleSignatureAppender().addSignature("common-lib").addSignature(moduleName).getSignatures();
	}
	
}
