package fancyHashMapImpl;

import java.util.HashMap;
import java.util.LinkedList;

public class FancyHash{

LinkedList<String> valueList;
HashMap<String, String> hashMapList;

    public FancyHash(){
        valueList = new LinkedList<String>();
        hashMapList = new HashMap<String, String>();
    }

    public void delete(String key){
        valueList.remove(hashMapList.get(key));
        hashMapList.remove(key);
    }
    
    public String getAt(int i){
        return valueList.get(i);
    }
    
    public String get(String key){
        return hashMapList.get(key);
    }
    
    public void put(String key, String value){
        hashMapList.put(key,value);
        valueList.addLast(value);
    }
    
public static void main(String[] args) {

     FancyHash ea = new FancyHash();
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