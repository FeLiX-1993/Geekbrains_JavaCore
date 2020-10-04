public class Dog extends Animal {

    private static final double RUN_LIMIT_DEFAULT    = 500;
    private static final double SWIM_LIMIT_DEFAULT   = 0.5;
    private static final double JUMP_LIMIT_DEFAULT   = 10;

    public Dog(String name) {
        super(name, RUN_LIMIT_DEFAULT, JUMP_LIMIT_DEFAULT, SWIM_LIMIT_DEFAULT);
    }

    public Dog(String name, double runLimit, double jumpLimit, double swimLimit) {
        super(name, runLimit, jumpLimit, swimLimit);
    }

    @Override
    public void run(double distance) {
        System.out.printf("%s run: %s\n", this, distance <= getRunLimit());
    };

    @Override
    public void jump(double height) {
        System.out.printf("%s jump: %s\n", this, height <= getJumpLimit());
    };

    @Override
    public void swim(double distance) {
        System.out.printf("%s swim: %s\n", this, distance <= getSwimLimit());
    };

    @Override
    public String toString() {
        return String.format("Dog \"%s\"", getName());
    }

}
