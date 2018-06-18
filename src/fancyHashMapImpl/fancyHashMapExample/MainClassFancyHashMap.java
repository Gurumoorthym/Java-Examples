package fancyHashMapImpl.fancyHashMapExample;

public class MainClassFancyHashMap {
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
