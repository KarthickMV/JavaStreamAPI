package com.Karthick.stream.basics;

import java.util.Arrays;
import java.util.List;

public class LazyInvocation {
	
	private long counter=0;
	
	private void wasCalled() {
		counter++;
	}
	
	public void lazyInvocation() {
		
		
		/*
		 * Intermediate operations are lazy. 
		 * This means that they will be invoked only if it is necessary for the terminal operation execution.
		 */
		
			List<String> list = Arrays.asList("abc1","abc2","abc3");
			counter=0;
			Stream<String> stream = list.stream().filter
	}

}
