package cs544;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AppBook {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Book book1 = new Book("Harry Potter", "812123", "Nolan", 240.0, dateFormat.parse("2003-06-01"));
        // save the book
        em.persist(book1);
        Book book2 = new Book("Lord of the Rings", "813432123", "Nolan2", 240.0, dateFormat.parse("2003-06-01"));
        em.persist(book2);
        Book book3 = new Book("Mongolia", "888888", "Nolan4", 240.0, dateFormat.parse("1162-06-01"));
        // save the book
        em.persist(book3);
        // Create new instance of Book and set values in it
        
        em.getTransaction().commit();
        em.close();

        // retieve all books
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        List<Book> bookList = query.getResultList();
        for (Book book : bookList) {
            System.out.println("Title= " + book.getTitle() + ", ISBN= "
                    + book.getISBN() + ", Autor= " + book.getAuthor()+ ", Price= " + book.getPrice()+ ", Publish Date= " + book.getPublish_date());
        }
        em.getTransaction().commit();
        em.close();


        // Retrieve all books from the database, and then:
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book> query2 = em.createQuery("from Book", Book.class);
        List<Book> bookList2 = query2.getResultList();
        for (Book book : bookList2) {
            if (book.getISBN().equals("888888")){
                book.setTitle("The Secret of Mongolian");
                book.setPrice(1000);
            }else{
                em.remove(book);
            }
        }
        em.getTransaction().commit();
        em.close();

        // retieve all books
        em = emf.createEntityManager();
        em.getTransaction().begin();
        query = em.createQuery("from Book", Book.class);
        bookList = query.getResultList();
        for (Book book : bookList) {
            System.out.println("Title= " + book.getTitle() + ", ISBN= "
                    + book.getISBN() + ", Autor= " + book.getAuthor()+ ", Price= " + book.getPrice()+ ", Publish Date= " + book.getPublish_date());
        }
        em.getTransaction().commit();
        em.close();
    }
}
