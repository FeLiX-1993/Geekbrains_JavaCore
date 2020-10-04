public class Main {

    public static void main(String[] args) {

        // Экзепмляр кота
        Animal catFelix = new Cat("Felix");
        System.out.println(catFelix);
        catFelix.run(150);
        catFelix.jump(5);
        catFelix.swim(20);

        // Экземпляр собаки
        Animal dogJay = new Dog("Jay");
        System.out.println(dogJay);
        dogJay.run(400);
        dogJay.jump(0.3);
        dogJay.swim(7);

        // Расброс в органичениях реализован с помощью конструтора с произвольными лимитами
        Animal dogThunder = new Dog("Thunder", 1000, 1, 10);
        System.out.println(dogThunder);
        dogThunder.run(400);
        dogThunder.jump(0.3);
        dogThunder.swim(7);

    }
}
