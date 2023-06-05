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
        Owner owner1 = new Owner("Baysaa", "Fairfield");
        em.persist(owner1);
        Car car1 = new Car("BMW", "SDA231", 30221.00, owner1);
        // save the car
        em.persist(car1);
        // Create new instance of Car and set values in it
        Owner owner2 = new Owner("Shujat", "Fairfield");
        em.persist(owner2);
        Car car2 = new Car("Mercedes", "HOO100", 4088.00, owner2);
        // save the car
        em.persist(car2);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            System.out.println(car);
        }
        em.getTransaction().commit();
        em.close();
    }
}

