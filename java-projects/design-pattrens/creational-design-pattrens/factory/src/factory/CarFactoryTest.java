package factory;

public class CarFactoryTest {

	public static void main(String[] args) {
		CarFactory factory = new CarFactory();
		Car benz = factory.getCar("Benz");
		benz.display();
		
		Car bmw = factory.getCar("Bmw");
		bmw.display();
		
		Car audi = factory.getCar("Audi");
		audi.display();

	}

}
