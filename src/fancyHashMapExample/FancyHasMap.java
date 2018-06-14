package fancyHashMapExample;

public class FancyHasMap {
	
	
	LinkedFancyHashMap<FancyHash> linkedFancyHashMap = new LinkedFancyHashMap<FancyHash>();
	
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
		linkedFancyHashMap.remove(key);
	}
}
