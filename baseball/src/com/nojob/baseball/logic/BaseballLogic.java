package com.nojob.baseball.logic;

import java.util.ArrayList;

public class BaseballLogic {
	public static int[] numbers = new int[4];
	public static int strikes;
	public static int balls;

	public static int[] inputTointAry(String str) {
		int[] inputnums = new int[4];
		char[] inputArray = str.toCharArray();

		int i = 0;
		for (char cha : inputArray) {
			inputnums[i] = Character.getNumericValue(cha);
			i++;
		}

		return inputnums;
	}
	

	public static void genNumber() {
		for (int t = 0; t < 4; t++)
			if (t == 0) {
				numbers[0] = (int) (Math.random() * 9 + 1);
			} else {
				loop1: while (true) {
					int temp = (int) (Math.random() * 9 + 1);
					for (int i = 0; i < 4; i++) {
						if (numbers[i] == temp)
							continue loop1;
					}
					numbers[t] = temp;
					break loop1;
				}
			}
	}

	public static void logic(ArrayList<Integer> inputnums) {
		strikes = 0;
		balls = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < inputnums.size(); j++) {
				if (numbers[i] == inputnums.get(j)) {
					if (i == j) strikes++;
					else balls++;
				}
			}
		}
	}
}
