public abstract class Vehicle implements Brand {

 	private int wheels;
 	private String brandName;
	/**
	 * Class Constructor
	 * @param wheels    number of wheels
	 * @param brandName Name of the brand
	 * When this constructor is called from its respective subclasses
	 */
 	public Vehicle(int wheels, String brandName) {
 		this.wheels = wheels;
 		this.brandName = brandName;
 	}

  public Vehicle(int wheels){
    this.wheels = wheels;
  }

 	public int getWheels() {
 		return wheels;
 	}

 	public String getBrandName() {
 		return brandName;
 	}

 }
