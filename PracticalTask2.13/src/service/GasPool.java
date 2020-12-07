package service;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GasPool {

    private static final float DEFAULT_FUEL_CAPACITY = 1000;

    private float fuelCapacity;
    private float fuelRemaining;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public GasPool() {
        this.fuelCapacity   = DEFAULT_FUEL_CAPACITY;
        this.fuelRemaining  = DEFAULT_FUEL_CAPACITY;
    }

    public float request(float amount) {
        lock.writeLock().lock();
        float factAmount = Math.min(fuelRemaining, amount);
        fuelRemaining = fuelRemaining - factAmount;
        lock.writeLock().unlock();
        return factAmount;
    }

    public void info() {
        lock.readLock().lock();
        System.out.printf("Fuel remaining: %s\n", fuelRemaining);
        lock.readLock().unlock();
    }

}
