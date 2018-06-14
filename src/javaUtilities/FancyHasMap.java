package javaUtilities;

import java.util.Iterator;
import java.util.LinkedList;

public class FancyHasMap {
	
	/*
	 * FancyHashMap Class is created to mimic the HashMap Functionality of holding a key and value
	 */
	public class FancyHash{
		String key;
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		String value;
	}
	
	LinkedList<FancyHash> linkedFancyHashMap = new LinkedList<FancyHash>();
	
	/*
	 * Putter to store the Key and Value pair as a linkedList
	 */
	public void put(String key, String value) {
		FancyHash fancyHash = new FancyHash();
		fancyHash.setKey(key);
		fancyHash.setValue(value);
		linkedFancyHashMap.addLast(fancyHash);
	}
	
	/*
	 *Getter to fetch at the index of the list 
	 */
	public String getAt(int i) {
		if(i<linkedFancyHashMap.size()) {
			return linkedFancyHashMap.get(i).getValue();
		}
		return null;
	}
	
	/*
	 * Delete a particular list with the value string
	 */
	public void delete(String key) {
		Iterator<FancyHash> i = linkedFancyHashMap.iterator();
		while(i.hasNext()) {
			if(i.next().getKey().equalsIgnoreCase(key)) {
				i.remove();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		FancyHasMap a = new FancyHasMap();
	    a.put("Paul", "stuff1");    
	    a.put("Tom", "stuff2");
	    a.put("Peter", "stuff3");
	    a.put("Mary", "stuff4");
	    a.put("Mary", "stuff5");
	    
	    //assertEquals(a.getAt(2),"stuff3");
	    System.out.println(a.getAt(2));
	    a.delete("Tom");
	    //assertEquals(a.getAt(1),"stuff3");
	    System.out.println(a.getAt(1));
	    a.delete("Paul");
	    //assertEquals(a.getAt(0),"stuff3");
	    System.out.println(a.getAt(0));
	}
	

}
