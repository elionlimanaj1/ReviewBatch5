package com.review2.Maps;

import java.util.*;
import java.util.Map.Entry;

public class EnglishAlbanianDictionary {

	public static void main(String[] args) {
		Map<String, String> englishAlbanian = new HashMap<>();

		englishAlbanian.put("good", "mire");
		englishAlbanian.put("house", "shtepi");
		englishAlbanian.put("hi", "ckemi");

		// I am overriding the key "hi"
		englishAlbanian.put("hi", "pershendetje");
		englishAlbanian.put("well", "mire");

		System.out.println(englishAlbanian);
		// insertion order is not maintained for entries

		String englishHouse = "house";
		String albanianHouse = englishAlbanian.get(englishHouse);
		System.out.println(englishHouse + " -> " + albanianHouse);

		Map<String, String> albanianEnglish = new HashMap<String, String>();
		albanianEnglish.put("mire", "good");
		albanianEnglish.put("shtepi", "house");
		albanianEnglish.put("pershendetje", "hi");

		System.out.println("The english for shtepi: " + albanianEnglish.get("shtepi"));

		System.out.println("---keySet()---");
		Set<String> keys = englishAlbanian.keySet();
		Iterator<String> keyIt = keys.iterator();
//		if (keyIt.hasNext()) { // if there is a next element, it safe to get it.
//			keyIt.next();
//		}
		while (keyIt.hasNext()) { // if there is a next element, it safe to get it.
			String key = keyIt.next();
			System.out.println(key + " = " + englishAlbanian.get(key));
		}

//		for (String key :keys) {
//			System.out.println(key + " = " + englishAlbanian.get(key));
//		}

		System.out.println("---values()---");
		Collection<String> valueColl = englishAlbanian.values();
		for (String val : valueColl) {
			System.out.println(val);
		}

		// A Map is a Set of Entries!!!!
		System.out.println("---entrySet()---");
		// Set<Pair> = Set of pairs
		Set<Entry<String, String>> entries = englishAlbanian.entrySet();

		for (Entry<String, String> entry : entries) {
//			System.out.println(entry);
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " -> " + value);
		}

		// HW for Bertan and others
		// Create a dictionary English - Your language
		// enter at least 10 random words
		// Print the dictionary by getting the entries and using Iterator
		// Try to change it to HashMap, LinkedHashMap, TreeMap

	}
}