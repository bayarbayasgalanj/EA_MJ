package cs544;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao implements IBookDao {
	@PersistenceContext
	private EntityManager em;


	public BookDao() {
		// add(new Book("Volvo", "S80", 1999, "Silver"));
		// add(new Book("Honda", "Accord", 1997, "Red"));
	}
	
	@Override
	public List<Book> getAll() {
		return em.createQuery("from Book", Book.class).getResultList();
	}
	
	@Override
	public void add(Book book) {
		em.persist(book);
	}
	
	@Override
	public Book get(int id) {
		return em.find(Book.class, id);
	}
	
	@Override
	public void update(Book book) {
		em.merge(book);
	}
	
	@Override
	public void delete(int bookId) {
		Book c = em.getReference(Book.class, bookId);
		em.remove(c);
	}
}
