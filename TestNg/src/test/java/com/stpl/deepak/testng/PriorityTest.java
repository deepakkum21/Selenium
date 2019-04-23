package com.stpl.deepak.testng;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class PriorityTest {
	@Test(priority = 1)
	  public void c_test() {
		  Assert.fail();
	  }
	  
	  @Test(priority = 3)
	  public void a_test() {
		  Assert.assertTrue(true);
	  }
	  
	  @Test(priority = 8)
	  public void b_test() {
		  throw new SkipException("Test case skipped");
	  }
}
