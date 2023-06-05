package cs544;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Patient patient = new Patient("John Doe", "100 Main Street", "23114", "Boston");
        em.persist(patient);
        Doctor doctor = new Doctor("Eye Doctor", "Frank", "Brown");
        em.persist(doctor);
        Date dt = (new SimpleDateFormat("dd/MM/yyyy")).parse("05/06/2023");
        Payment payment = new Payment();
        payment.setAmount(100);
        payment.setPaydate(dt);
        Appointment appointment = new Appointment(dt, patient, payment, doctor);
        em.persist(appointment);
        em.getTransaction().commit();
        em.close();
    }
}