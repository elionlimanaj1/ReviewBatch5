package com.review1.Collection;

import java.util.*;

public class InitializeArrayList {

	public static void main(String[] args) {

		// List, preserves insertion order, contains duplicates
		// LinkedList
		// ArrayList

		// Set, doesn't preserve insertion order, doesn't allow duplicates
		// HashSet
		// LinkedHashSet
		// TreeSet

		// 1st way
		List<String> europe = new ArrayList<>();
		europe.add("France");
		europe.add("Italy");
		europe.add("Germany");
		europe.add(1, "Belgium");

		System.out.println("europe " + europe);

		// 2nd way
		List<String> asia = new ArrayList<String>() {
			{
				add("China");
				add("India");
				add("Nepal");
			}
		};

		asia.add("Turkey");
		System.out.println("asia " + asia);

		// 3rd way, the list is immutable, you cannot add element
		String[] strArray = { "Somali", "Nigeria", "South Africa" };
		List<String> africa = Arrays.asList(strArray);
		// africa.add("Tunisia");

		System.out.println("africa " + africa);

		// 4th way, the list is mutable/changable
		List<String> africa2 = new ArrayList<>(africa);
		africa2.add("Tunisia");
		System.out.println("africa2 " + africa2);

		// 5th way, this will work only with Java 9
		// List<String> northAmerica = new ArrayList<String>(List.of("US",
		// "Canada","Mexico"));

		Set<String> europeSet = new TreeSet<String>(europe);
		System.out.println("europeSet " + europeSet);

	}

}
