package basics;

public class Car {
	    private String make;
	    private String model;
	    private int year;

	    public Car(String make, String model, int year) {
	        this.make = make;
	        this.model = model;
	        this.year = year;
	    }

	    public String getMake() {
	        return make;
	    }

	    public void setMake(String make) {
	        this.make = make;
	    }

	    public String getModel() {
	        return model;
	    }

	    public void setModel(String model) {
	        this.model = model;
	    }

	    public int getYear() {
	        return year;
	    }

	    public void setYear(int year) {
	        this.year = year;
	    }

	    public void startEngine() {
	        System.out.println("The engine has started.");
	    }

	    public static void main(String[] args) {
	        Car myCar = new Car("Toyota", "Camry", 2022);
	        System.out.println("Car Make: " + myCar.getMake());
	        System.out.println("Car Model: " + myCar.getModel());
	        System.out.println("Car Year: " + myCar.getYear());
	        myCar.startEngine();
	    }
	}



