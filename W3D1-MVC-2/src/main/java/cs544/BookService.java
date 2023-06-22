package cs544;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {
    @Autowired
    private IBookDao bookDao;
    
    public List<Book> getAll() {
        return bookDao.findAll();
    }

    public void add(Book book) {
        bookDao.save(book);
    }

    public Book get(int id) {
        return bookDao.getById((long) id);
        // Book book = bookDao.getById((long) id);
        // Hibernate.initialize(book.getTitle());
        // return book;
    }

    public void update(Book book) {
        bookDao.save(book);
    }

    public void delete(int id) {
        bookDao.delete(get(id));
    }
}