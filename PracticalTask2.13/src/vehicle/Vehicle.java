package vehicle;

import service.FuelStation;

public abstract class Vehicle implements Runnable {

    protected String name;
    protected String registrationNumber;
    protected float fuelCapacity;
    protected float fuelConsumption;
    protected float fuelRemaining;

    public Vehicle(String name, String registrationNumber, float fuelCapacity, float fuelConsumption) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumption = fuelConsumption;
        this.fuelRemaining = fuelCapacity;
    }

    public float getRequiredFuel() {
        return fuelCapacity - fuelRemaining;
    }

    public void addFuel(float amount) {
        this.fuelRemaining += amount;
    }

    public void drive() {

        System.out.printf("%s is driving\n", this);

        while (fuelRemaining != 0) {
            try {
                Thread.sleep(2000);
                fuelRemaining = Math.max(fuelRemaining - fuelConsumption, 0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        FuelStation.getFuelStation().refuelTheVehicle(this);
        drive();
    }

    @Override
    public void run() {
        drive();
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
