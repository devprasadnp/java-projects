package singleton;


public class Singleton {

	// Private static instance of the class
    private static Singleton instance;

    // Private constructor to prevent external instantiation
    private Singleton() {
        // Initialization code, if needed
    }

    // Public static method to provide access to the single instance
    public static Singleton getInstance() {
        // Lazy initialization: create the instance only if it doesn't exist
        if (instance == null) {
        	synchronized (Singleton.class) {
        		if(instance == null) {
        			instance = new Singleton();
        		}
        	}
        }
        return instance;
    }

    // Example method of the Singleton class
    public void showMessage() {
        System.out.println("Hello from the Singleton instance! ==> " + instance);
    }
}
