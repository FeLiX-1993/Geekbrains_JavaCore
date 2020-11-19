package hometask.fruits;

import hometask.fruits.Fruit;

public class Orange extends Fruit {

    private static final float DEFAULT_WEIGHT = 1.5f;

    public Orange() {
        this(DEFAULT_WEIGHT);
    }

    public Orange(float weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "hometask.fruits.Orange{" +
                "weight=" + weight +
                '}';
    }
}
