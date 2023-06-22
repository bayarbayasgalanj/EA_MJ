package cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class Client  implements CommandLineRunner {
    @Autowired
    private CarService carService;

    @Override
    public void run(String... args) {
        Car p = carService.get(1L);
        carService.add(new Car("Toyota", "Land 300",2002,"green"));
        System.out.println(carService.getAll());
        p.setColor("black");
        carService.update(p);
        System.out.println(carService.getAll());
        carService.delete((int)2L);
        System.out.println(carService.getAll());
        p = carService.getAll().get(0);
        System.out.println(p.getMake());
    }
}
