package edu.soumya.maven.multimoduletest.dependency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import edu.soumya.maven.multimoduletest.CommonNModuleSignatureAdder;

public class TestSignatures {
	@Test
	public void testAllSignatures() {
		String commonModuleName = "common-lib";
		String moduleName = "dependent-module1";
		Set<String> signatureSet = CommonNModuleSignatureAdder.addCommonNModuleSignature(moduleName);
		assertEquals(2,signatureSet.size());
		assertTrue(signatureSet.contains(commonModuleName));
		assertTrue(signatureSet.contains(moduleName));
	}
}
