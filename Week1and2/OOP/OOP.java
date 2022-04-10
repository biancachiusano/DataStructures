public class OOP {


	/*
	 * Program in Java the following structure:
		You should have the following classes/interfaces:
		 Vehicle,Car,Motorbike,Brand,BMWCar,BMWMotorbike,VWCar
		 Select whether it is an class, abstract class or interface based on the principals of OOP.
		 The following relations must be implemented:
		 A Vehicle is either a car or a Motorbike
		 A BMWCar is a car, a BMWMotorbike is a motorbike and a VWCar is a car.
		 BMWCar, BMWMotorbike and VMCar inherit from Brand.
		 On objects of the type  Vehicle,Car,Motorbike,Brand,BMWCar,BMWMotorbike,VWCar you can call the methods:
		   - public int getWheels() which returns the number of wheels
		   - public String getBrandName() which returns "BMW" or "VW"
		 And object of type brand has only the method getBrandName().
		 Try to minimize the redundant code.
	 */

	public static void main(String[] args) {
		Car bmw = new BMWCar();

		VWCar vw = new VWCar();

	System.out.println(vw.getBrandName() + " , " + vw.getWheels());

		Car c = new Car();
		System.out.println(c.getBrandName() + " , " + c.getWheels());

		Motorbike mb = new BMWMotorbike();

		Motorbike bmwm = new BMWMotorbike();

		System.out.println("BR: " + bmw.getBrandName());

		Brand b = new Car();
		System.out.println(b.getBrandName());



	}
}
