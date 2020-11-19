package hometask.fruits;

import java.util.ArrayList;

public class Box <T extends Fruit> {

    private ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void remove(T fruit) {
        fruits.remove(fruit);
    }

    public float getWeight() {
        float weight = 0;
        for (T fruit: fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compareTo(Box<?> anotherBox) {
        return getWeight() == anotherBox.getWeight();
    }

    public void transferTo(Box<T> anotherBox) {

        for (T fruit: fruits) {
            anotherBox.add(fruit);
            fruits.remove(fruit);
        }
    }

    @Override
    public String toString() {
        return "hometask.fruits.Box{" +
                "fruits=" + fruits +
                '}';
    }
}
