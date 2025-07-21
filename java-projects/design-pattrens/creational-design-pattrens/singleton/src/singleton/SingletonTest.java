package singleton;

public class SingletonTest {

	public static void main(String args[]) {
		Singleton singletonObj = Singleton.getInstance();
		singletonObj.showMessage();
		Singleton singletonObj2 = Singleton.getInstance();
		singletonObj2.showMessage();
		Singleton singletonObj3 = Singleton.getInstance();
		singletonObj3.showMessage();
	}
}
