public class Main {

    public static void main(String[] args) {

        Cat[] cats = new Cat[]{
                new Cat("Jake", 5, 20),
                new Cat("Max", 10, 30),
                new Cat("Suzanna", 15, 100),
                new Cat("Felix", 40, 5),
                new Cat("Robert", 10, 30),
        };


        Plate plate = new Plate(30);

        Cat.eat(cats, plate);

        for (int i = 0; i < cats.length; i++) {
            cats[i].info();
        }

    }
}
