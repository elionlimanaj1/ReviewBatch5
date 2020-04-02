package com.review2;

import java.util.*;
import java.util.Map.Entry;

public class WorldMap {

	public static void main(String[] args) {
		Map<String, String> europeMap = new HashMap<String, String>();
		europeMap.put("France", "Paris");
		europeMap.put("Italy", "Rome");
		europeMap.put("Germany", "Berlin");
		System.out.println(europeMap);

		Map<String, String> asiaMap = new HashMap<String, String>();
		asiaMap.put("China", "Beijing");
		asiaMap.put("India", "New Dehli");
		asiaMap.put("Nepal", "Kathmandu");
		System.out.println(asiaMap);

		Map<String, String> africaMap = new HashMap<String, String>();
		africaMap.put("Somali", "Pretoria");
		africaMap.put("Nigeria", "Niger");
		africaMap.put("South Africa", "Cape Town");
		System.out.println(africaMap);

		System.out.println("---------------------------");
		List<Map<String, String>> worldList = new ArrayList<Map<String, String>>();
		worldList.add(europeMap);
		worldList.add(africaMap);
		worldList.add(asiaMap);
		System.out.println(worldList);

		System.out.println("---Iterate worldList---");
		for (Map<String, String> continent : worldList) {
			System.out.println(continent);
			// HW for Harman, iterate the continent by using keys.
		}
		System.out.println("---------------------------");
		Map<String, Map<String, String>> worldMap = new HashMap<String, Map<String, String>>();
		worldMap.put("africa", africaMap);
		worldMap.put("europe", europeMap);
		worldMap.put("asia", asiaMap);
		System.out.println(worldMap);

		System.out.println("---entrySet()---");
		// You cannot iterate a map.
		// 1. You can get the keys into a Set
		// 2. You can get the values into a Collection
		// 3. You can get the entries into a Set of Entries
		
		// get the entries from the map into a Set of entries
		Set<Entry<String, Map<String, String>>> worldSet = worldMap.entrySet();

		for (Entry<String, Map<String, String>> entry : worldSet) {
//			System.out.println(entry);
			System.out.println(entry.getKey());

			Map<String, String> continentMap = entry.getValue();
			System.out.println(continentMap);

			// HW for Esra, iterate the continentMap

		}

	}

}
