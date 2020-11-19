package hometask.fruits;

public class Apple extends Fruit {

    private static final float DEFAULT_WEIGHT = 1.0f;

    public Apple() {
        this(DEFAULT_WEIGHT);
    }

    public Apple(float weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "hometask.fruits.Apple{" +
                "weight=" + weight +
                '}';
    }
}

