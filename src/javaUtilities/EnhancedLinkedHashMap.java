package javaUtilities;

import java.util.HashMap;
import java.util.LinkedList;

public class EnhancedLinkedHashMap {
	
	/*
	 * FancyHashMap Class is created to mimic the HashMap Functionality of holding a key and value
	 */
	public class FancyHash extends HashMap<String,String>{
		/**
		 * 
		 */
		private static final long serialVersionUID = 7195203157942720987L;

		/*
		 * Overloaded method of getKey() 
		 * compared between the actual key from the indexed object of the linkedlist of HashMaps
		 * and the actual HashMap
		 */
		public String getKey(FancyHash actualHash, FancyHash comparedHash) {
			String actualHashMapKey;
			String derivedHashMapKey;
			for(String key: comparedHash.keySet()) {
				actualHashMapKey = comparedHash.get(key);
				derivedHashMapKey = actualHash.get(key);
				if(null != derivedHashMapKey && null != actualHashMapKey 
						&& derivedHashMapKey.equals(actualHashMapKey)) {
					return key;
				}
			}
			return null;
		}
	}
	
	LinkedList<FancyHash> linkedFancyHashMap;
	FancyHash fancyHash;
	
	public EnhancedLinkedHashMap() {
		linkedFancyHashMap = new LinkedList<FancyHash>();
		fancyHash =  new FancyHash();
	}
	
	/*
	 * It uses only one get(Key) implementation rather than the getAt(i) which does the retrieval thrice
	 * removing the actual object from the linkedlist of hashmaps
	 */
	private void delete(String key) {
		FancyHash fancyHashObj = new FancyHash();
		fancyHashObj.put(key, fancyHash.get(key));
		fancyHash.remove(key);
		linkedFancyHashMap.remove(fancyHashObj);
	}

	/*
	 * Uses direct HashMap retrival from the super class implementation so its faster retrieval
	 */
	private String get(String key) {
		return fancyHash.get(key);
	}

	/*
	 *Uses direct HashMap put method and additionally populating the linkedlist of Hashmaps for index retrival
	 */
	private void put(String key, String value) {
		FancyHash fancyHashObj = new FancyHash();
		fancyHashObj.put(key, value);
		linkedFancyHashMap.addLast(fancyHashObj);
		fancyHash.put(key, value);
	}

	/*
	 * Optimized to fetch the key by comparing the fetched index from the linked list which holds the order, 
	 * thereby retrieving the value from the actual hashMap super class implementation
	 */
	private String getAt(int i) {
		return fancyHash.get(fancyHash.getKey(linkedFancyHashMap.get(i),fancyHash));
	}
	
	public static void main(String[] args) {
		EnhancedLinkedHashMap ea = new EnhancedLinkedHashMap();
		ea.put("Guru1" , "Stream1");
		ea.put("Guru2" , "Stream2");
		ea.put("Guru3" , "Stream3");
		ea.put("Guru4" , "Stream4");
		ea.put("Guru5" , "Stream5");
		ea.put("Guru6" , "Stream6");
		
		System.out.println("Get Value of Guru3: " +  ea.get("Guru3"));//Should return Stream3
		System.out.println("Get Value at Index 2: " +  ea.getAt(2));//Should return Stream3
		
		ea.delete("Guru2");
		
		System.out.println("Get Value of Guru3: " + ea.get("Guru3"));//Should return Stream3
		System.out.println("Get Value at Index 1: " + ea.getAt(1));//Should return Stream3
		
		ea.delete("Guru1");
		
		System.out.println("Get Value of Guru3: " + ea.get("Guru3"));//Should return Stream3
		System.out.println("Get Value at Index 0: " + ea.getAt(0));//Should return Stream3
		
		ea.put("Guru2" , "Stream2");
		
		System.out.println("Get Value of Guru3: " + ea.get("Guru2"));//Should return Stream2
		System.out.println("Get Value at Index 4: " + ea.getAt(4));//Should return Stream2
		
		ea.put("Guru1" , "Stream1");

		System.out.println("Get Value of Guru3: " + ea.get("Guru1"));//Should return Stream1
		System.out.println("Get Value at Index 5: " + ea.getAt(5));//Should return Stream1
		
	}

}
