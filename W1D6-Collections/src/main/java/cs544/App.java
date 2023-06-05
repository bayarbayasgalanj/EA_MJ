package cs544;

import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class App {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create new instance and set values in it
        Laptop l1 = new Laptop("Mac", "Pro 14ich");
        em.persist(l1);
        Laptop l2 = new Laptop("Mac", "Air 13ich");
        em.persist(l2);
        Employee em1 = new Employee("Baysaa","Jagdal");
        em1.addLaptop(l1);
        em1.addLaptop(l2);
        em.persist(em1);
        
        // retieve all
        System.out.println("-------------------PART A EMPLOYEE--------------");
        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
        List<Employee> eList = query.getResultList();
        for (Employee e : eList) {
            System.out.println(e);
        }
        
        Flight flight1 = new Flight("ABC123", "CityA", "CityB", new Date());
        Flight flight2 = new Flight("ABC99", "CityB", "CityC", new Date());
        em.persist(flight1);
        em.persist(flight2);
        Passenger passenger = new Passenger("John Depp");
        passenger.getFlight_ids().add(flight1);
        passenger.getFlight_ids().add(flight2);
        em.persist(passenger);
        System.out.println("-------------------PART B PASSENGER--------------");
        TypedQuery<Passenger> q2 = em.createQuery("from Passenger", Passenger.class);
        List<Passenger> lst2 = q2.getResultList();
        for (Passenger e : lst2) {
            System.out.println(e);
        }

        School school = new School("MIU School");
        Student student1 = new Student("John", "Depp");
        Student student2 = new Student("Baysaa", "Jagdal");
        em.persist(student1);
        em.persist(student2);
        school.addStudent(student1);
        school.addStudent(student2);
        em.persist(school);
        System.out.println("-------------------PART C SCHOOL--------------");
        TypedQuery<School> q3 = em.createQuery("from School", School.class);
        List<School> lst3 = q3.getResultList();
        for (School e : lst3) {
            System.out.println(e);
        }

        em.getTransaction().commit();
        em.close();
    }
}

