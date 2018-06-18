package fancyHashMapImpl.fancyHashMapExample;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

/*
 * Overriding the functionalities of LinkedList but using the getter method if Hash Map
 */

public class LinkedFancyHashMap<E> extends LinkedList<E> {

	private static final long serialVersionUID = 1L;
	
	private HashMap<Integer, E> hash = new HashMap<Integer, E>();
	
	private E fancyHash;
	
	public E getFancyHash() {
		return fancyHash;
	}

	public void setFancyHash(E fancyHash) {
		this.fancyHash = fancyHash;
	}
	
	/*
	 * Addind the hashmap so we can have faster retival
	 * @see java.util.LinkedList#addLast(java.lang.Object)
	 */
	@Override
	public void addLast(E e) {
		super.addLast(e);
		hash.put(this.indexOf(e), e);
    }
	/*
	 * Method uses hashmap fetch to get the value rather iterating through the list
	 * @see java.util.LinkedList#get(int)
	 */
	@Override
	public E get(int index) {
		return hash.get(index);
	}    
	
	//Remove method to remove from the actual map rather than the list
	public void remove(String key) {
		ListIterator<E> it = this.listIterator();
		while(it.hasNext()) {
			FancyHash fancyHash = (FancyHash) it.next();
			if(fancyHash.getKey().equalsIgnoreCase(key)) {
				it.remove();
				resetHashMap();
			}
		}
    }

	//Reset the hashMap with respect to the indexing
	private void resetHashMap() {
		hash = new HashMap<Integer, E>();
		for(E e : this) {
			hash.put(this.indexOf(e), e);
		}
	}
	
	
}
