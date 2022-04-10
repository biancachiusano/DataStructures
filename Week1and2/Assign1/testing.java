public class testing{

  public static void main(String[] args){

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
