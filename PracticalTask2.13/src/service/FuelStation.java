package service;

import vehicle.Vehicle;

import java.util.concurrent.Semaphore;

public class FuelStation {

    private static FuelStation fuelStation;
    private GasPool gasPool;
    private Semaphore smp;

    private FuelStation() {
        this.gasPool = new GasPool();
        this.smp = new Semaphore(3);
    };

    public static synchronized FuelStation getFuelStation() {
        if (fuelStation == null)
            fuelStation = new FuelStation();
        return fuelStation;
    }

    public void refuelTheVehicle(Vehicle vehicle) {

        try {
            System.out.printf("%s has arrived at the gas station, free places: %s\n", vehicle, smp.availablePermits());
            smp.acquire();
            System.out.printf("%s is refueling now, free places: %s\n", vehicle, smp.availablePermits());
            Thread.sleep(8000);
            float factAmount = gasPool.request(vehicle.getRequiredFuel());
            vehicle.addFuel(factAmount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("%s has refueled\n", vehicle);
            smp.release();
        }

    }

}
