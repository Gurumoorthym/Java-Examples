package fancyHashMapExample;

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
	
	@Override
	public void addLast(E e) {
		super.addLast(e);
		hash.put(this.indexOf(e), e);
    }
	
	@Override
	public E get(int index) {
		return hash.get(index);
	}    
	
	
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
	
	private void resetHashMap() {
		hash = new HashMap<Integer, E>();
		for(E e : this) {
			hash.put(this.indexOf(e), e);
		}
	}
	
	
}
