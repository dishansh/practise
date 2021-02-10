/**
 * 
 */
package com.nationwide.codingtest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dishansh
 *
 */

class ValueMaxComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		String val1 = ""+o1+o2;
		String val2 = ""+o2+o1;
		return Integer.parseInt(val2) >= Integer.parseInt(val1) ? 1 : -1;
	}
	
}

class ValueMinComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		String val1 = ""+o1+o2;
		String val2 = ""+o2+o1;
		return Integer.parseInt(val1) >= Integer.parseInt(val2) ? 1 : -1;
	}
	
}

public class Nationwide {
	
	public static int getLayerMaximum(int n) {
		if (n < 0) {
			return -1;
		}
		return Math.pow(2, n) > Integer.MAX_VALUE ? -1 : (int) Math.pow(2, n);
	}

	public static int findDifference(int[] input) {
		
		ValueMaxComparator maxComparator = new ValueMaxComparator();
		ValueMinComparator minComparator = new ValueMinComparator();

		StringBuilder sb = new StringBuilder();
		Arrays.stream(input).boxed().sorted(maxComparator).forEach(i -> {
			sb.append(i);
		});
		
		if(Double.valueOf(sb.toString()) > Integer.MAX_VALUE) {
			return -1;
		}
		
		int maxValue = Integer.valueOf(sb.toString());
		System.out.println("Maximum Value: "+maxValue);

		StringBuilder sbr = new StringBuilder();
		int[] minValueArray = Arrays.stream(input).boxed().sorted(minComparator).mapToInt(i -> i.intValue()).toArray();
		
		if(minValueArray[0] == 0) {
			Integer temp = minValueArray[1];
			minValueArray[1] = 0;
			minValueArray[0] = temp;
		}
		
		Arrays.stream(minValueArray).forEach(i -> {
			sbr.append(i);
		});
		
		int minValue = Integer.valueOf(sbr.toString());
		System.out.println("Minimum Value: "+minValue);

		return (maxValue - minValue);
	}

	public static void main(String[] args) {
		System.out.println("Pascal Triangle's 4th Layer Sum: \n"+getLayerMaximum(4));
		System.out.println("Difference of Maximum and Minimum Number from the array is : \n"+ findDifference(new int[] { 3, 4, 0, 1, 5, 6, 8, 7, 2 }));
	}

}
