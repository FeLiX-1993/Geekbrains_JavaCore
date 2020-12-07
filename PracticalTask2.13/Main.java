import vehicle.Bus;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Bus("Volvo 9700", "A785KE"));
        vehicles.add(new Truck("Mersedes Actros", "A433PH"));
        vehicles.add(new Car("BMW M5", "А888XX"));
        vehicles.add(new Car("Ford Focus", "M800LI"));
        vehicles.add(new Car("Honda Accord", "R600NR"));
        vehicles.add(new Car("Toyota Rav4", "T500IO"));
        vehicles.add(new Car("Toyota Rav4", "T600IO"));
        vehicles.add(new Car("Toyota Rav4", "T700IO"));
        vehicles.add(new Car("Toyota Rav4", "T800IO"));

        ExecutorService executorService = Executors.newFixedThreadPool(vehicles.size());
        for (Vehicle vehicle: vehicles) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.submit(vehicle);
        }
        executorService.shutdown();

    }
}
