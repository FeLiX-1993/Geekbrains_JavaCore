public class Main {

    public static void main(String[] args) {

        Obstacle obstacles[] = new Obstacle[] {
                new Track(50),
                new Wall(2),
                new Wall(3),
                new Track(99)
        };

        Competitor[] competitors = new Competitor[] {
                new Cat("Felix", 20, 2),
                new Human("Jack", 50, 3),
                new Robot("I9108", 100, 100)
        };

        Competetion competetion  = new Competetion(competitors, obstacles);
        competetion.start();

    }
}
