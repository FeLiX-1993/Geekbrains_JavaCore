public abstract class Animal {

    private String name;
    private double runLimit;
    private double jumpLimit;
    private double swimLimit;

    public Animal(String name, double runLimit, double jumpLimit, double swimLimit) {
        this.name       = name;
        this.runLimit   = runLimit;
        this.jumpLimit  = jumpLimit;
        this.swimLimit  = swimLimit;
    }

    public String getName() {
        return name;
    }

    public double getRunLimit() {
        return runLimit;
    }

    public double getJumpLimit() {
        return jumpLimit;
    }

    public double getSwimLimit() {
        return swimLimit;
    }

    public abstract void run(double distance);

    public abstract void jump(double height);

    public abstract void swim(double distance);
}
