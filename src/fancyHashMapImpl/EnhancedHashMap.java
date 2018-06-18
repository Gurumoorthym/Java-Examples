package fancyHashMapImpl;

import java.util.HashMap;
import java.util.Iterator;

public class EnhancedHashMap {
	
	private HashMap<Integer, HashMap<String,String>> fetchHashMap;
	private HashMap<String,String> actualHashMap;
	private int counter = 0;
	
	public EnhancedHashMap(){
		this.fetchHashMap = new HashMap<Integer, HashMap<String,String>>();
		this.actualHashMap = new HashMap<String,String>();
	}
	
	public void delete(String key) {
		Iterator<HashMap<String,String>> it = this.fetchHashMap.values().iterator();
		HashMap<String,String> comparedValue;
		HashMap<String,String> actualValue;
		while(it.hasNext()) {
			comparedValue = (HashMap<String,String>)it.next();
			actualValue = new HashMap<String,String>();
			actualValue.put(key, this.actualHashMap.get(key));
			if(actualValue.equals(comparedValue)) {
				actualHashMap.remove(key);
				it.remove();
				resetFetchHashKeys();
				counter--;
				break;
			}
		}
		
	}


	public String getAt(int i) {
		HashMap<String, String> hashMap = this.fetchHashMap.get(i);
		String actualHashMapKey;
		String derivedHashMapKey;
		for(String key: this.actualHashMap.keySet()) {
			actualHashMapKey = this.actualHashMap.get(key);
			derivedHashMapKey = hashMap.get(key);
			if(null != derivedHashMapKey && null != actualHashMapKey 
					&& derivedHashMapKey.equals(actualHashMapKey)) {
				return actualHashMapKey;
			}
			
		}
		return null;
	}


	public void push(String key, String value) {
		HashMap<String,String> actualMap = new HashMap<String,String>();
		actualMap.put(key,value);
		this.actualHashMap.put(key, value);
		this.fetchHashMap.put(counter++, actualMap);
	}
	
	private void resetFetchHashKeys() {
		for(int i=0;i<fetchHashMap.size();i++) {
			if(null == fetchHashMap.get(i)) {
				fetchHashMap.put(i,fetchHashMap.get(i+1));
				fetchHashMap.remove(i+1);
			}
		}
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
