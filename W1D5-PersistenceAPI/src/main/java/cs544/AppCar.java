package cs544;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AppCar {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create new instance of Car and set values in it
        Car car1 = new Car("BMW", "SDA231", 30221.00);
        // save the car
        // System.out.println("Em contains Car1 before clear "+car1);
        // em.clear();
        em.persist(car1);
        // em.clear();
        // Create new instance of Car and set values in it
        Car car2 = new Car("Mercedes", "HOO100", 4088.00);
        // save the car
        em.persist(car2);
        
        System.out.println("Em contains Car1 before clear: " + em.contains(car1));
        em.clear();
        System.out.println("Em contains Car1 after clear: " + em.contains(car1));

        // Part2
        car1.setPrice(50000);
        car1 = em.merge(car1);
        car1.setYear("2022");

        em.getTransaction().commit();
        em.close();
    }
}
