package factory;

public class CarFactory {
	public Car getCar(String type) {
        if ("Bmw".equalsIgnoreCase(type)) {
            return new Bmw();
        } else if ("Benz".equalsIgnoreCase(type)) {
            return new Benz();
        }  else if ("Audi".equalsIgnoreCase(type)) {
            return new Audi();
        } else {
            throw new IllegalArgumentException("Unknown Car type: " + type);
        }
    }
}
