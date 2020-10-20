public class Human implements Competitor {

    private String name;
    private int runLimit;
    private int jumpLimit;

    public Human(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public boolean run(Track track) {
        if (runLimit >= track.getLength()){
            System.out.printf("%s ran %s successfully\n", this, track);
            return true;
        } else {
            System.out.printf("%s didn't run %s\n", this, track);
            return false;
        }
    }

    @Override
    public boolean jump(Wall wall) {
        if (runLimit >= wall.getHeight()){
            System.out.printf("%s jumped %s successfully\n", this, wall);
            return true;
        } else {
            System.out.printf("%s didn't jump %s\n", this, wall);
            return false;
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                '}';
    }
}
