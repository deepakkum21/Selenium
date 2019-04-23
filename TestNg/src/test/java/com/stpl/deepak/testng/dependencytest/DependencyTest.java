package com.stpl.deepak.testng.dependencytest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {
	String message = "Deepak";
	MessageUtil messageUtil = new MessageUtil(message);

	   @Test
	   public void testPrintMessage() {
	      System.out.println("Inside testPrintMessage()");
	      message = "Deepak";
	      Assert.assertEquals(message, messageUtil.printMessage());
	   }

	   @Test(dependsOnMethods = { "initEnvironmentTest" })
	   public void testSalutationMessage() {
	      System.out.println("Inside testSalutationMessage()");
	      message = "Hi!" + "Deepak";
	      Assert.assertEquals(message, messageUtil.salutationMessage());
	   }

	   @Test
	   public void initEnvironmentTest() {
	      System.out.println("This is initEnvironmentTest");
	   }
}
