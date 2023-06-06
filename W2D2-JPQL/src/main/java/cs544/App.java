package cs544;

import java.util.List;

import cs544.model.Airline;
import cs544.model.Flight;
import java.text.DateFormat;
import java.util.Locale;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TemporalType;
import jakarta.persistence.TypedQuery;

public class App {

        private static EntityManagerFactory emf;

        public static void main(String[] args) throws Exception {
                emf = Persistence.createEntityManagerFactory("cs544");

                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();

                // a) TODO: Flights leaving USA capacity > 500
                System.out.println("Question A:");
                List<Flight> flights = em.createQuery("from Flight f"
                +" where f.airplane.capacity > 500 and f.origin.country = 'USA'"
                , Flight.class).getResultList();
                System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:", "Arrives:");
                for (Flight flight : flights) {
                        System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s %8s\n",
                                        flight.getFlightnr(), flight.getOrigin().getCity(),
                                        flight.getDepartureDate(), flight.getDepartureTime(),
                                        flight.getDestination().getCity(),
                                        flight.getArrivalDate(), flight.getArrivalTime()
                                        , flight.getAirplane().getCapacity());
                }
                System.out.println();

                em.getTransaction().commit();
                em.close();

                em = emf.createEntityManager();
                em.getTransaction().begin();

                // b) TODO: All airlines that use A380 airplanes
                System.out.println("Question B:");
                List<Airline> airlines = em.createQuery("from Airline al "
                +" JOIN al.flights as f "
                +" where f.airplane.model = 'A380' "
                // +" where al.flights.airplane.model = 'A380' "
                , Airline.class).getResultList();
                System.out.printf("Airlines that use A380s:\n");
                for (Airline airline : airlines) {
                        System.out.println(airline.getName());
                }
                System.out.println();

                em.getTransaction().commit();
                em.close();

                em = emf.createEntityManager();
                em.getTransaction().begin();

                // c) TODO: Flights using 747 planes that don't belong to Star Alliance
                System.out.println("Question C:");
                flights = em.createQuery("from Flight as f "
                +" where f.airplane.model = '747' and f.airline.name!='Star Alliance'"
                , Flight.class).getResultList();
                System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                                "Arrives:");
                for (Flight flight : flights) {
                        System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                                        flight.getFlightnr(), flight.getOrigin().getCity(),
                                        flight.getDepartureDate(), flight.getDepartureTime(),
                                        flight.getDestination().getCity(),
                                        flight.getArrivalDate(), flight.getArrivalTime());
                }
                System.out.println();

                em.getTransaction().commit();
                em.close();

                em = emf.createEntityManager();
                em.getTransaction().begin();

                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
                                Locale.US);
                DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
                                Locale.US);

                // d) TODO: All flights leaving before 12pm on 08/07/2009
                System.out.println("Question D:");
                // Query query = em.createQuery("delete Book where publish_date < :date"); 
                
                TypedQuery<Flight> query = em.createQuery("from Flight as f"
                +" where f.departureDate = :date and f.departureTime<=:time"
                , Flight.class);
                query.setParameter("date", df.parse("08/07/2009"), TemporalType.DATE);
                query.setParameter("time", tf.parse("12:00 PM"), TemporalType.TIME);
                flights = query.getResultList();
                System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                                "Arrives:");
                for (Flight flight : flights) {
                        System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                                        flight.getFlightnr(), flight.getOrigin().getCity(),
                                        flight.getDepartureDate(), flight.getDepartureTime(),
                                        flight.getDestination().getCity(),
                                        flight.getArrivalDate(), flight.getArrivalTime());
                }
                System.out.println();
                em.getTransaction().commit();
                em.close();
        }
}
