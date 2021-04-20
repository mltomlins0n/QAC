package com.qa.Streams;

import java.util.List;
import java.util.Arrays;
import java.util.stream.*;

public class Streams {
	
	public static Stream<Integer> numbers1 = Stream.iterate(1, n -> n+1)
			.limit(100);
	
	public static Stream<Integer> numbers2 = Stream.iterate(100, n -> n+1)
			.limit(900);
	
	public static List<Integer> numList1 = numbers1.collect(Collectors.toList());
	public static List<Integer> numList2 = numbers2.collect(Collectors.toList());
	
	
	public void printList1() {
		numList1.stream().forEach(System.out::println);
	}
	
	public void printList2() {
		numList2.stream().forEach(System.out::println);
	}
	
	public void multiplyListItems(List<Integer> numList) {
		numList.stream().map(num -> num * 10).forEach(System.out::println);
	}
}
