package javaUtilities;

import java.util.HashMap;

public class EnhancedHashMap {
	
	private HashMap<Integer, HashMap<String,String>> fetchHashMap;
	private HashMap<String,String> actualHashMap;
	private int counter = 0;
	
	public EnhancedHashMap(){
		this.fetchHashMap = new HashMap<Integer, HashMap<String,String>>();
		this.actualHashMap = new HashMap<String,String>();
	}
	
	private void delete(String string) {
		// TODO Auto-generated method stub
		
	}


	private char[] getAt(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	private void push(String string, String string2) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		EnhancedHashMap ea = new EnhancedHashMap();
		ea.push("Guru1","Stream1");
		ea.push("Guru2","Stream2");
		ea.push("Guru3","Stream3");
		ea.push("Guru4","Stream4");
		ea.push("Guru5","Stream5");
		ea.push("Guru6","Stream6");
		
		System.out.println(ea.getAt(2));//Should return Stream3
		
		ea.delete("Guru2");
		
		System.out.println(ea.getAt(1));//Should return Stream3
		
		ea.delete("Guru1");
		
		System.out.println(ea.getAt(0));//Should return Stream3
		
		ea.push("Guru2","Stream2");
		
		System.out.println(ea.getAt(4));//Should return Stream2
		
		ea.push("Guru1","Stream1");

		System.out.println(ea.getAt(5));//Should return Stream1
		
	}

}
