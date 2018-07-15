package singleton;

public class Test{


	public static void main(String[] args) {
		Singleton s = Singleton.getSingletonInstance();
		//System.out.println(s.getValue().hashCode());
		Singleton s1 = Singleton.getSingletonInstance();
		//System.out.println(s1.getValue().hashCode());
		
		if(s.getValue().hashCode()==s1.getValue().hashCode()) {
			System.out.println("Same Instance oF SINGLETON class");
		}
	}
}