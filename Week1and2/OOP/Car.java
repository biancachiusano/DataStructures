public class Car extends Vehicle{

/**
 * A car always has 4 wheels, thus this is a static variable
 * that is passed to the superclass (Brand.java). On the other hand,
 * the BrandName changes based on the car. Both BMWCar and VWCar extend to this class
 */
	public Car(){
		super(4);
	}

	public Car(String brandName) {
		super(4, brandName);
	}
}
