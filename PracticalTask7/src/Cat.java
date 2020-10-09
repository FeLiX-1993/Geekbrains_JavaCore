public class Cat {

    private String name;
    private int appetite;
    private int fullNess;
    private int Powerful;

    public Cat(String name, int appetite, int Powerful) {
        this.name = name;
        this.appetite = appetite;
        this.Powerful = Powerful;
        this.fullNess = 0;
    }

    public void eat(Plate p) {
        if (fullNess == appetite)
            return;
        int availableFood = p.getAvailableFood(appetite - fullNess);
        if (availableFood == 0)
            return;
        p.decreaseFood(availableFood);
        fullNess = availableFood;
    }

    public static void eat(Cat[] cats, Plate p) {

        // Упорядочим котов по иерархии
        sortByPowerful(cats);

        // Кормим котов
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(p);
        }

    }

    private static void sortByPowerful(Cat[] cats) {

        for (int i = 0; i < cats.length-1; i++) {
            for (int j = 0; j < cats.length-1; j++) {
                if (cats[j].Powerful < cats[j+1].Powerful) {
                    Cat bufCat = cats[j+1];
                    cats[j+1] = cats[j];
                    cats[j] = bufCat;
                }
            }
        }
    }

    public void info() {
        System.out.printf("cat: %s, appetite: %s fullness: %s, %S\n", name, appetite, fullNess, appetite == fullNess);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", fullNess=" + fullNess +
                ", Powerful=" + Powerful +
                '}';
    }
}
