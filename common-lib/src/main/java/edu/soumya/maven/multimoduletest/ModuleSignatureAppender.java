package edu.soumya.maven.multimoduletest;

import java.util.HashSet;
import java.util.Set;

public class ModuleSignatureAppender {
	Set<String> moduleSignature;
	
	public ModuleSignatureAppender addSignature(String moduleName) {
		if(this.moduleSignature == null) {
			this.moduleSignature = new HashSet<>();
		}
		this.moduleSignature.add(moduleName);
		return this;
	}
	
	public Set<String> getSignatures() {
		return this.moduleSignature;
	}
}