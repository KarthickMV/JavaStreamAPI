package com.Karthick.stream.basics;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReferencingStream {
	
	public void referenceStream() {
		
		/*
		 * We can instantiate a stream and have an accessible reference to it, as long as only intermediate operations are called.
		 * Executing a terminal operation makes a stream inaccessible.
		 * 
		 */
		
		/*
		 * Example of trying to access a stream element after calling the terminal operation
		 * 
		 */
		
			Stream<String> stream = Stream.of("a","b","c").filter(x-> x.contains("b"));
			Optional<String> anyElement = stream.findAny();
			
			/*
			 * However, an attempt to reuse the same reference after calling the terminal operation will trigger the IllegalStateException
			 */
			
			try {
				Optional<String> firstElement = stream.findFirst();
				System.out.println(firstElement);
			}catch(IllegalStateException e) {
				e.printStackTrace();
			}
		
		/*
		 * To avoid this issue the data must be stored from the stream first before retrieving
		 */
			
			List<String> elements = Stream.of("a","b","c").filter(x->x.contains("b")).collect(Collectors.toList());
			Optional<String> firstElement = elements.stream().findFirst();
			Optional<String> randomElement = elements.stream().findAny();
	}

}
