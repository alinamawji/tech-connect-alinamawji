package com.techelevator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		if ((animalName == null) || (animalName == "")) {
			return "unknown";
		}

		animalName = animalName.toLowerCase();
		HashMap<String, String> animalGroups = new HashMap<String, String>() {{
			put("rhino", "Crash");
			put("giraffe", "Tower");
			put("elephant", "Herd");
			put("lion", "Pride");
			put("crow", "Murder");
			put("pigeon", "Kit");
			put("flamingo", "Pat");
			put("deer", "Herd");
			put("dog", "Pack");
			put("crocodile", "Float");
		}};

		if (animalGroups.containsKey(animalName)) {
			Iterator iter = animalGroups.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry current = (Map.Entry)iter.next();
				if (((String)current.getKey()).equals(animalName)) {
					return (String)current.getValue();
				}
			}
		}
		return "unknown";
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {
		if ((itemNumber == null) || (itemNumber == "")) {
			return 0.00;
		}

		itemNumber = itemNumber.toUpperCase();
		HashMap<String, Double> salePercentages = new HashMap<String, Double>() {{
			put("KITCHEN4001", 0.20);
			put("GARAGE1070", 0.15);
			put("LIVINGROOM", 0.10);
			put("KITCHEN6073", 0.40);
			put("BEDROOM3434", 0.60);
			put("BATH0073", 0.15);
		}};

		if (salePercentages.containsKey(itemNumber)) {
			Iterator iter = salePercentages.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry current = (Map.Entry)iter.next();
				if (((String)current.getKey()).equals(itemNumber)) {
					return (Double)current.getValue();
				}
			}
		}
		return 0.00;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		int peterAmt = peterPaul.get("Peter");
		int paulAmt = peterPaul.get("Paul");

		if ((peterAmt > 0) && (paulAmt < 1000)) {
			int difference = peterAmt / 2;
			peterPaul.replace("Peter", peterAmt - difference);
			peterPaul.replace("Paul", paulAmt + difference);
		}

		return peterPaul;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		int peterAmt = peterPaul.get("Peter");
		int paulAmt = peterPaul.get("Paul");

		if ((peterAmt >= 5000) && (paulAmt >= 10000)) {
			int peterContribution = peterAmt / 4;
			int paulContribution = paulAmt / 4;
			peterPaul.put("PeterPaulPartnership", peterContribution + paulContribution);
			peterPaul.replace("Peter", peterAmt - peterContribution);
			peterPaul.replace("Paul", paulAmt - paulContribution);
		}

		return peterPaul;
	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		Map<String, String> charMap = new HashMap<>();

		for (String word : words) {
			String firstLetter = String.valueOf(word.charAt(0));
			String lastLetter = String.valueOf(word.charAt(word.length()-1));
			charMap.put(firstLetter, lastLetter);
		}

		return charMap;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		Map<String, Integer> wordCounts = new HashMap<>();
		for (String currentWord : words) {
			int count = 0;
			for (String word : words) {
				if (currentWord.equals(word)) {
					count += 1;
				}
			}
			wordCounts.put(currentWord, count);
		}

		return wordCounts;

	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		Map<Integer, Integer> wordCounts = new HashMap<>();
		for (int currentInt : ints) {
			int count = 0;
			for (int i : ints) {
				if (currentInt == i) {
					count += 1;
				}
			}
			wordCounts.put(currentInt, count);
		}

		return wordCounts;
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		Map<String, Boolean> wordCounts = new HashMap<>();
		for (String currentWord : words) {
			int count = 0;
			boolean appearsMoreThanTwice = false;
			for (String word : words) {
				if (currentWord.equals(word)) {
					count += 1;
				}
			}
			if (count >= 2) {
				appearsMoreThanTwice = true;
			}
			wordCounts.put(currentWord, appearsMoreThanTwice);
		}

		return wordCounts;
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {
		Map<String, Integer> skuCounts = new HashMap<>();
		for (Map.Entry<String, Integer> item : mainWarehouse.entrySet()) {
			String key = item.getKey();
			if (remoteWarehouse.containsKey(key)) {
				int mainCount = mainWarehouse.get(key);
				int remoteCount = remoteWarehouse.get(key);
				skuCounts.put(key, mainCount + remoteCount);
				remoteWarehouse.remove(key);
			} else {
				int mainCount = mainWarehouse.get(key);
				skuCounts.put(key, mainCount);
			}
		}
		if (remoteWarehouse.size() != 0) {
			for (Map.Entry<String, Integer> item : remoteWarehouse.entrySet()) {
				skuCounts.put(item.getKey(), item.getValue());
			}
		}
		return skuCounts;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		Map<String, Integer> counts = new HashMap<>();

		for (String word : words) {
			int wordLength = word.length();
			int count = 0;

			if ((wordLength == 0) || (wordLength == 1) || (wordLength == 2)) {
				counts.put(word, count);
			} else {
				String origSubstr = word.substring(wordLength-2);
				for (int i = 0; i < wordLength-2; i++) {
					String currentSubstr = word.substring(i, i+2);
					System.out.println(currentSubstr);
					if (currentSubstr.equals(origSubstr)) {
						count += 1;
					}
				}
				counts.put(word, count);
			}
		}

		return counts;
	}

}
