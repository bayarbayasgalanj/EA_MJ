package cs544;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class StudentDAO {

    @PersistenceContext
    private EntityManager em;
    
    public List<Student> getAll() {
        return em.createQuery("from Student", Student.class).getResultList();
    }

    public Student load(long studentId) {
        return em.find(Student.class, studentId);
    }
}
