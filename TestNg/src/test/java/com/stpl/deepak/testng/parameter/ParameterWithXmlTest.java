package com.stpl.deepak.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterWithXmlTest {
	@Test
	@Parameters("myName")
	public void parameterTest(String myName) {
		System.out.println("Parameterized value is : " + myName);
	}
}
