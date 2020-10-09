public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public int getFoodToDecrease(int requestedFood) {
        return Math.min(food, requestedFood);
    }

    public void decreaseFood(int n) {
        food = Math.max(0,food-n);
    }

    public void increaseFood(int n) {
        food = +food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}
