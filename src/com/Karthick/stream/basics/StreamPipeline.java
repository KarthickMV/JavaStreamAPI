package com.Karthick.stream.basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamPipeline {

	public void streamPipeline() {
		
		/*
		 * To perform a sequence of operations over the elements of the data source and aggregate their results, 
		 * we need three parts: the source, intermediate operation(s) and a terminal operation.
		 */
			
			Stream<String> onceModifiedStream = Stream.of("abc","bcd","cde").skip(1);
			
			/*
			 * An important thing to be noted is that a stream operation will not be carried out until the terminal operation 
			 * is performed. 
			 * 
			 * 	A stream by itself is worthless; the user is interested in the result of the terminal operation,
			 *  which can be a value of some type or an action applied to every element of the stream. 
			 *  We can only use one terminal operation per stream.
			 *  
			 *	The correct and most convenient way to use streams is by a stream pipeline, 
			 *	which is a chain of the stream source, intermediate operations, and a terminal operation:
			 * 
			 */
			
			List<String> list = Arrays.asList("abcd","bcde","cdef");
			long count = list.stream()
							.skip(1)
							.map(element->element.substring(1,3))
							.sorted()
							.count();
	}
	
}
