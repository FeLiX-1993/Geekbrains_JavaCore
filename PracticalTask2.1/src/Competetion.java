import java.util.Arrays;

public class Competetion {

    private Competitor competitors[];
    private Obstacle obstacles[];

    public Competetion(Competitor[] competitors, Obstacle[] obstacles) {
        this.competitors = competitors;
        this.obstacles = obstacles;
    }

    public void start() {

        Competitor lastCompetitors[] = Arrays.copyOf(competitors, competitors.length);

        for (Obstacle obstacle : obstacles) {

            Competitor currentLastCompetitors[] = new Competitor[0];
            for (Competitor competitor : lastCompetitors) {
                if (obstacle.pass(competitor)) {
                    currentLastCompetitors = Arrays.copyOf(currentLastCompetitors, currentLastCompetitors.length + 1);
                    currentLastCompetitors[currentLastCompetitors.length - 1] = competitor;
                }
            }
            lastCompetitors = Arrays.copyOf(currentLastCompetitors, currentLastCompetitors.length);
        }

        if (lastCompetitors.length > 0)
            System.out.printf("The following competitors won : %s\n", Arrays.toString(lastCompetitors));
        else
            System.out.println("Nobody won");
    }
}

