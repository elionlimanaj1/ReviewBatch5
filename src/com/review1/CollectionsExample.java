package com.review1;

import java.util.*;

//Collection Framework with no s
//Collections is a helper class, which has some methods, similar to CommonMethods class
public class CollectionsExample {

	public static void main(String[] args) {
		List<String> europe = new ArrayList<>();
		europe.add("France");
		europe.add("Italy");
		europe.add("Germany");
		europe.add(1, "Belgium");

		Collections.addAll(europe, "Albania", "Greece");
		System.out.println("After addAll " + europe);

		String[] other = { "Romania", "Portugal" };
		Collections.addAll(europe, other);
		System.out.println("After others " + europe);

		////////////////////////////////////////////
		// int primitive -> Integer is the wrapper class
		// char primitive -> Character is the wrapper class
		// double primitive -> Double is the wrapper class

//		Integer b = 6;// auto boxing
//		Integer c = new Integer(7);// normal boxing
//		boolean equal = b.equals(c);
//
//		int d = b.intValue();// normal unboxing, unwrap (my terminology)
//		int e = c;// auto unboxing, auto unwrapping (my terminology)

		List<Integer> integers = new ArrayList<>();
		integers.add(3);
		integers.add(9);
		integers.add(1);
		integers.add(6);

		System.out.println(integers);
		Integer min = Collections.min(integers);
		System.out.println("min = " + min);
		System.out.println("max = " + Collections.max(integers));

		Collections.sort(integers);
		System.out.println("sorted list " + integers);

		Collections.sort(integers, Collections.reverseOrder());
		System.out.println("reverse list " + integers);

	}
}
