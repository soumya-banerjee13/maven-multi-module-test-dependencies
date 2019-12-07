package edu.soumya.maven.multimoduletest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

public class TestSignatures {
	
	@Test
	public void testAllSignatures() {
		String moduleName = "common-lib";
		Set<String> signatureSet = CommonNModuleSignatureAdder.addCommonNModuleSignature(moduleName);
		assertEquals(1,signatureSet.size());
		assertTrue(signatureSet.contains(moduleName));
	}
}
