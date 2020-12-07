package vehicle;

public class Truck extends Vehicle {

    private static final float DEFAULT_FUEL_CAPACITY = 60;
    private static final float DEFAULT_FUEL_CONSUMPTION = 15;

    public Truck(String name, String registrationNumber) {
        super(name, registrationNumber, DEFAULT_FUEL_CAPACITY, DEFAULT_FUEL_CONSUMPTION);
    }

    @Override
    public String toString() {
        return "Truck{" +
                "name='" + name + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
