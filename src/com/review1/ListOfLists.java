package com.review1;

import java.util.*;

public class ListOfLists {
	// Create a List of Lists
	// Let's use continents as Lists
	// Put them into World, which is a list of continents

	public static void main(String[] args) {
		List<String> europe = new ArrayList<>();
		europe.add("France");
		europe.add("Italy");
		europe.add("Germany");
		europe.add(1, "Belgium");

		List<String> asia = new ArrayList<String>() {
			{
				add("China");
				add("India");
				add("Nepal");
			}
		};

		String[] strArray = { "Somali", "Nigeria", "South Africa" };
		List<String> africa = new ArrayList<>(Arrays.asList(strArray));
		africa.add("Tunisia");

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(3);
		numbers.add(6);
		numbers.add(2);

		List<List<String>> world = new ArrayList<>();
		world.add(europe);
		world.add(asia);
		world.add(africa);
		// world.add(numbers);

		System.out.println("world = " + world);

		// Iterate or loop a collection
		// 1st way, normal for loop, only in a List. You cannot use in a Set
		// 2nd way, enhanced/advanced for loop
		// 3rd way, iterator

		// 1st way, normal for loop
		for (int i = 0; i < world.size(); i++) {
			List<String> continent = world.get(i);
		}

		// 2nd way, enhanced/advanced for loop
		for (List<String> continent : world) {
			System.out.println();
			System.out.println("continent countries = " + continent);
			for (String country : continent) {
				System.out.println(country);
			}
		}

		System.out.println("\n---Iterator--");

		// 3rd way, using iterator
		Iterator<List<String>> worldIterator = world.iterator();
//		List<String> continent1 = worldIterator.next();
//		List<String> continent2 = worldIterator.next();
//		List<String> continent3 = worldIterator.next();
//		List<String> continent4 = worldIterator.next();
//		System.out.println(continent3);

		while (worldIterator.hasNext()) {
			List<String> continent = worldIterator.next();
			System.out.println(continent);

			Iterator<String> continentIterator = continent.iterator();
			while (continentIterator.hasNext()) {
				String country = continentIterator.next();
				System.out.println(country);
			}
			System.out.println();
		}

		// This is homework for Fatma Ziyanak
		List<List<List<String>>> milkyWay;
	}

}
