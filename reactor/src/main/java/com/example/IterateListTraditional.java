package com.example;

import java.util.Arrays;
import java.util.List;

public class IterateListTraditional {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		System.out.println("Traditional For Loop");
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}

		System.out.println("Enhanced For Loop");
		for (Integer num : numbers) {
			System.out.println(num);
		}

	}

}
