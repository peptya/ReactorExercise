package com.example;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapIteration {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Pranit", "Kokne", "Java Developer");

		Map<Integer, String> namesMap = new LinkedHashMap<>();

		for (int i = 0; i < names.size(); i++) {
			namesMap.put(i, names.get(i));
		}

		namesMap.forEach((key, value) -> System.out.println("Key : " + key + " Value : " + value));

	}

}
