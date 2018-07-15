package javaUtilities;

import java.util.Arrays;
import java.util.Collections;

public class ArraySort {
	public static void main(String[] args) {
		String[] stringArray = {"43","2","73","4"};
		
		Arrays.sort(stringArray,Collections.reverseOrder());
		//Collections.sort(Arrays.asList(stringArray),Collections.reverseOrder());
		//Arrays.asList(stringArray).sort(Collections.reverseOrder());
		
		Arrays.asList(stringArray).stream().forEach(System.out::print);
	}
}
