public class Track implements Obstacle {

    private int length;

    public Track(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean pass(Competitor competitor) {
        return competitor.run(this);
    }

    @Override
    public String toString() {
        return "Track{" +
                "length=" + length +
                '}';
    }
}
