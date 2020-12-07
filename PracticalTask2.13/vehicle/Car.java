package vehicle;

public class Car extends Vehicle {

    private static final float DEFAULT_FUEL_CAPACITY = 20;
    private static final float DEFAULT_FUEL_CONSUMPTION = 2.5f;

    public Car(String name, String registrationNumber) {
        super(name, registrationNumber, DEFAULT_FUEL_CAPACITY, DEFAULT_FUEL_CONSUMPTION);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
