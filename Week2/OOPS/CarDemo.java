package basics;

public class CarDemo {
	public static void main(String[] args) {
        Car[] cars = {
            new Car("Toyota", "Camry", 2022),
            new ElectricCar("Tesla", "Model S", 2023, 400)
        };

        for (Car car : cars) {
            car.startEngine();
        }
    }

}
