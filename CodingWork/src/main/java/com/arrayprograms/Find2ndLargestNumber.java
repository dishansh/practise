package com.arrayprograms;

public class Find2ndLargestNumber {
	
	public static int findLargestNumberInAnArray(int[] numbers) {
		int max = numbers[0];
		for(int number : numbers) {
			if(number > max) {
				max = number;
			}
		}
		return max;
	}
	
	public static int find2ndLargestNumberInAnArray(int[] numbers) {
		int max = numbers[0];
		int maxSecond = max;
		for(int number : numbers) {
			if(number > max) {
				maxSecond = max;
				max = number;
			}
			if(number < max && number > maxSecond) {
				maxSecond = number;
			}
		}
		return maxSecond;
	}

	public static void main(String[] args) {
		int[] numbers = {22,22,33,44,432,144,55,620};
		System.out.println("---------- Largest Number in Array --------------------");
		System.out.println(findLargestNumberInAnArray(numbers));
		System.out.println("---------- 2nd Largest Number in Array --------------------");
		System.out.println(find2ndLargestNumberInAnArray(numbers));
	}

}
