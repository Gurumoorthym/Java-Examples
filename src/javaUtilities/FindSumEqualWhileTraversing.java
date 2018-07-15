package javaUtilities;

import java.util.LinkedList;

public class FindSumEqualWhileTraversing {
	public static void main(String[] args) {
		LinkedList<String> numberList = new LinkedList<String>();
		numberList.add("3");
		numberList.add("5");
		numberList.add("1");
		numberList.add("3");
		numberList.add("3");
		numberList.add("5");
		numberList.add("3");
		for(int i=0, j=numberList.size()-1; i< numberList.size()/2; i++,j--) {
			if((numberList.get(i)+numberList.get(i+1)).equals(numberList.get(j)+numberList.get(j-1))){
				System.out.println(i+1);
				break;
			}
		}
	}
	
	
}
