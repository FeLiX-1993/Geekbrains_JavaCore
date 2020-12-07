package vehicle;

public class Bus extends Vehicle {

    private static final float DEFAULT_FUEL_CAPACITY = 40;
    private static final float DEFAULT_FUEL_CONSUMPTION = 7.5f;

    public Bus(String name, String registrationNumber) {
        super(name, registrationNumber, DEFAULT_FUEL_CAPACITY, DEFAULT_FUEL_CONSUMPTION);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "name='" + name + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
