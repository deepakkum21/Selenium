package com.stpl.deepak.testng.expectiontest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpectedExceptionTest {
	String message = "Deepak";	
	   MessageUtil messageUtil = new MessageUtil(message);
		   
	   @Test(expectedExceptions = ArithmeticException.class)
	   public void testPrintMessage() {	
	      System.out.println("Inside testPrintMessage()");     
	      messageUtil.printMessage();     
	   }
	   
	   @Test
	   public void testSalutationMessage() {
	      System.out.println("Inside testSalutationMessage()");
	      message = "Hi!" + "Deepak";
	      Assert.assertEquals(message,messageUtil.salutationMessage());
	   }
}
