package com.codetest.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

// Run the test from this file
public class TestsRun {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Running Test Suite for PersonTest.java
		Result resultPersonTest = JUnitCore.runClasses(PersonTest.class);
	      for (Failure failure : resultPersonTest.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println("All Test Running Successfully for PersonTest.java "+resultPersonTest.wasSuccessful());
	      
	    // Running Test Suite for JavaIOTest  
	  	Result resultJavaIOTest = JUnitCore.runClasses(JavaIOTest.class);
	      for (Failure failure : resultJavaIOTest.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println("All Test Running Successfully for JavaIOTest.java "+resultJavaIOTest.wasSuccessful());
	}

}
