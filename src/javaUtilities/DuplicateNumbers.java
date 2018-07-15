package javaUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class DuplicateNumbers {
	public static void main(String[] args) {
		ArrayList<String> duplicatedNumber = new ArrayList<String>();
		duplicatedNumber.add("3");
		duplicatedNumber.add("5");
		duplicatedNumber.add("1");
		duplicatedNumber.add("3");
		duplicatedNumber.add("3");
		duplicatedNumber.add("5");
		duplicatedNumber.add("3");
		
		duplicatedNumber.stream().filter(i->Collections.frequency(duplicatedNumber,i)>1).
			collect(Collectors.toSet()).forEach(s-> System.out.println(s +""));
	}
}
