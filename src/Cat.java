public class Cat extends Animal{

    private static final double RUN_LIMIT_DEFAULT    = 200;
    private static final double JUMP_LIMIT_DEFAULT   = 2;

    public Cat(String name) {
        super(name, RUN_LIMIT_DEFAULT, JUMP_LIMIT_DEFAULT, 0);
    }

    public Cat(String name, double runLimit, double jumpLimit) {
        super(name, runLimit, jumpLimit, 0);
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
        System.out.println("Cats can't swim");
    };

    @Override
    public String toString() {
        return String.format("Cat \"%s\"", getName());
    }
}
