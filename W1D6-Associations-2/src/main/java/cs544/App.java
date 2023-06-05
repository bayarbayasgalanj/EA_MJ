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
        Department department1 = new Department("HR");
        Department department2 = new Department("Engineering");
        Employee employee1 = new Employee("John Depp");
        Employee employee2 = new Employee("Baysaa Jag");
        // Associate employees with departments
        department1.getEmployees().add(employee1);
        department2.getEmployees().add(employee2);
        em.persist(employee1);
        em.persist(employee2);
        employee1.setDepartment(department1);
        employee2.setDepartment(department2);
        // Persist departments and employees
        em.persist(department1);
        em.persist(department2);
        System.out.println("-------------------PART A Bidirectional OneToMany Department Employee--------------");
        TypedQuery<Employee> q2 = em.createQuery("from Employee", Employee.class);
        List<Employee> lst2 = q2.getResultList();
        for (Employee e : lst2) {
            System.out.println(e);
        }

        Publisher publisher = new Publisher();
        publisher.setName("Publisher A");
        em.persist(publisher);
        // Create a book and associate it with the publisher
        Book book = new Book();
        book.setIsbn("123456789");
        book.setTitle("Book Title");
        book.setAuthor("Jack");
        book.setPublisher(publisher);
        em.persist(book);
        System.out.println("-------------------PART B Optional Unidirectional ManyToOne Publisher--------------");
        TypedQuery<Publisher> q3 = em.createQuery("from Publisher", Publisher.class);
        List<Publisher> lst3 = q3.getResultList();
        for (Publisher e : lst3) {
            System.out.println(e);
        }

        Student student1 = new Student();
        student1.setFirstname("John");
        student1.setLastname("Deph");
        Student student2 = new Student();
        student2.setFirstname("Baji");
        student2.setLastname("Jack");
        // Create courses
        Course course1 = new Course();
        course1.setCoursenumber("C001");
        course1.setName("Math");
        Course course2 = new Course();
        course2.setCoursenumber("C002");
        course2.setName("Physics");
        em.persist(course1);
        em.persist(course2);
        // Associate students with courses
        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        student2.getCourses().add(course2);
        // Persist students and courses
        em.persist(course1);
        em.persist(course2);
        em.persist(student1);
        em.persist(student2);
        System.out.println("-------------------PART C Bidirectional ManyToMany Student--------------");
        TypedQuery<Student> q4 = em.createQuery("from Student", Student.class);
        List<Student> lst4 = q4.getResultList();
        for (Student e : lst4) {
            System.out.println(e);
        }


        Customer customer = new Customer();
        customer.setName("John Deph");
        Reservation reservation1 = new Reservation();
        reservation1.setDate(new Date());
        Reservation reservation2 = new Reservation();
        reservation2.setDate(new Date());
        em.persist(reservation1);
        em.persist(reservation2);
        customer.getReservations().add(reservation1);
        customer.getReservations().add(reservation2);
        em.persist(customer);
        System.out.println("-------------------PART D UnidirectionalOneToMany--------------");
        TypedQuery<Customer> q5 = em.createQuery("from Customer", Customer.class);
        List<Customer> lst5 = q5.getResultList();
        for (Customer e : lst5) {
            System.out.println(e);
        }



        reservation1.setBook(book);
        reservation2.setBook(book);
        em.persist(reservation1);
        em.persist(reservation2);
        System.out.println("-------------------PART E Unidirectional ManyToOne--------------");
        q5 = em.createQuery("from Customer", Customer.class);
        lst5 = q5.getResultList();
        for (Customer e : lst5) {
            System.out.println(e);
        }


        Office office1 = new Office((long) 123, "Build1");
        employee1.setOffice(office1);
        employee2.setOffice(office1);
        em.persist(office1);
        // em.persist(office1);
        System.out.println("-------------------PART F Bidirectional ManyToOne--------------");
        TypedQuery<Employee> q6 = em.createQuery("from Employee", Employee.class);
        List<Employee> lst6 = q6.getResultList();
        for (Employee e : lst6) {
            System.out.println(e);
        }

        em.getTransaction().commit();
        em.close();
    }
}