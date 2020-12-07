package service;

import vehicle.Vehicle;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class FuelStation {

    private static FuelStation fuelStation;
    private GasPool gasPool;
    private Semaphore smp;
    private Queue queue;

    private FuelStation() {
        this.gasPool = new GasPool();
        this.smp = new Semaphore(3);
        this.queue = new Queue();
    };

    public static synchronized FuelStation getFuelStation() {
        if (fuelStation == null)
            fuelStation = new FuelStation();
        return fuelStation;
    }

    public void refuelTheVehicle(Vehicle vehicle) {

        try {
            System.out.printf("%s has arrived at the gas station, free places: %s\n", vehicle, smp.availablePermits());
            queue.addLast(vehicle);
            while (true) {
                smp.acquire();
                if (!vehicle.equals(queue.peekFirst())) {
                    smp.release();
                    continue;
                }
                queue.remove(vehicle);
                System.out.printf("%s is refueling now, free places: %s\n", vehicle, smp.availablePermits());
                Thread.sleep(8000);
                float factAmount = gasPool.request(vehicle.getRequiredFuel());
                vehicle.addFuel(factAmount);
                break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("%s has refueled\n", vehicle);
            smp.release();
        }

    }

    private class Queue {

        private ArrayDeque<Vehicle> arrayDeque;

        public Queue() {
            this.arrayDeque = new ArrayDeque<>();
        }

        public void addLast(Vehicle vehicle) {
            synchronized (this) {
                arrayDeque.addLast(vehicle);
            }
        }

        public Vehicle peekFirst() {
            synchronized (this) {
                return arrayDeque.peekFirst();
            }
        }

        public void remove(Vehicle vehicle) {
            synchronized (this) {
                arrayDeque.remove(vehicle);
            }
        }

    }

}
