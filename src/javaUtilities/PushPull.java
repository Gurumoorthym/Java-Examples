package javaUtilities;

import java.util.LinkedList;

public class PushPull {
	private static LinkedList<String> nameList = new LinkedList<String>();
	
	public static void pushLeft(String e) {
		nameList.addFirst(e);
	}
	public static void pushRight(String e) {
		nameList.addLast(e);
	}
	public static void pullRight() {
		nameList.removeLast();
	}
	public static void pullLeft() {
		nameList.removeFirst();
	}
	public static void pull(String e) {
		nameList.remove(e);
	}
	public static void push(String e) {
		nameList.add(e);
	}
	
	public static void main(String[] args) {
		pushLeft("John");
		pushLeft("Guru");
		pushRight("Aidan");
		pushRight("James");
		push("Patricia");
		
		pullLeft();
		pullRight();
		pull("Aidan");
		
		nameList.stream().forEach(System.out::println);
	}

}
