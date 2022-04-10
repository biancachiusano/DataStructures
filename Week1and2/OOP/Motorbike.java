public class Motorbike extends Vehicle{

	/**
	 * A Motorbike always has 2 wheels, thus this is a static variable
	 * that is passed to the superclass (Vehicle.java). On the other hand,
	 * the BrandName changes based on the MotorBike (even though, in this case there is only
	 * one type of Motorbike brand)
	 */

	public Motorbike(){
		super(2);
	}

	public Motorbike(String brandName) {
		super(2, brandName);
	}
}
