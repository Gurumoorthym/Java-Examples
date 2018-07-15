package Singleton;

public class Singleton {
	private static final Singleton singleton = new Singleton();
	private final String value = "SingletonInstance";
	public String getValue() {
		return value;
	}

	private Singleton() {
		
	}
	
	public static Singleton getSingletonInstance(){
		synchronized (singleton) {
			
		}
		return singleton;
	}

}
