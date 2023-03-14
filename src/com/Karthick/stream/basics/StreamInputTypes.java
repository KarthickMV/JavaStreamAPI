package com.Karthick.stream.basics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamInputTypes {
	
	public Stream<String> streamOf(List<String> list){
		return list==null || list.isEmpty() ? Stream.empty() : list.stream();
	}
	
	public void inputTypes() {
		
		/*
		 * Empty Stream creation, to handle cases where a empty case will not be returned.
		 * This is specially useful when we are unsure about the data within the source of the stream 
		 */
		
			Stream<String> emptyStream=Stream.empty();
			
			emptyStream = streamOf(Arrays.asList("a","b","c"));
		
		
		/*
		 * Stream of collection
		 */
		
			Collection<String> collection = Arrays.asList("a","b","c");
			Stream<String> streamOfCollection = collection.stream();
		
		/*
		 * Stream of Array - Full Array & Part Array
		 */
		
			Stream<String> streamOfArray = Stream.of("a","b","c");
			String[] arr = new String[]{"a","b","c"};
			Stream<String> fullArrayStream = Arrays.stream(arr);
			Stream<String> partialArrayStream = Arrays.stream(arr,1,3);
		
		/*
		 * Stream Builder 
		 */
		
			Stream.Builder<String> streamStringBuilder = Stream.builder();
			streamStringBuilder.accept("a");
			streamStringBuilder.accept("b");
			streamStringBuilder.accept("c");
			Stream<String> builderStream = streamStringBuilder.build();
			
			//Option2
			
			Stream<String> streamString = Stream.<String>builder().add("a").add("b").add("c").build();
		
			
		/*
		 * Stream generate
		 * 
		 *  The generate() method accepts a Supplier<T> for element generation. 
		 *  As the resulting stream is infinite, the developer should specify the desired size, or the generate() method will work until it 
		 *  reaches the memory limit:	
		 */
		
			Stream<String> generatedStream = Stream.generate(()->"comment").limit(20);
			
			
		/*
		 * Stream Iterate
		 * 
		 * The first element of the resulting stream is the first parameter of the iterate() method. 
		 * When creating every following element, the specified function is applied to the previous element. 
		 * In the example below the second element will be 42.
		 */
			
			Stream<Integer> integerStream = Stream.iterate(40, n->n+2).limit(20);	
		
		/*
		 * PrimitiveStreams
		 * 
		 * IntStream, LongStream and DoubleStream were created because the Stream by default takes generics and primitives 
		 * do not map to a generics
		 */
		
			IntStream intStream = IntStream.range(1,3);
			LongStream longStream= LongStream.rangeClosed(1, 3);
			
			Random random = new Random();
			DoubleStream doubleStream= random.doubles(3);
			
		/*
		 * Stream of String/Chars
		 */
			
			IntStream streamOfChars = "abc".chars();
			
			Stream<String> stringStream = Pattern.compile(", ").splitAsStream("a, b, c");
			
		/*
		 * Stream of Files
		 * 
		 * Java NIO class Files allows us to generate a Stream<String> of a text file through the lines() method. 
		 * Every line of the text becomes an element of the stream.
		 */
			try {
				Path path =  Paths.get("C:\\file.txt");
				Stream<String> streamOfStrings =  Files.lines(path);
				Stream<String> streamWithCharsets = Files.lines(path, Charset.forName("UTF-8"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
