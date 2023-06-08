package cs544;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
public class StudentDAO {

	private Collection<Student> studentlist = new ArrayList<Student>();

	public StudentDAO() {
		EntityManager em = EntityManagerHelper.getCurrent();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Student student = new Student(12345, "Frank", "Brown");
        em.persist(student);
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		student.addCourse(course1);
		student.addCourse(course2);
		studentlist.add(student);
		
		em.persist(course1);
		em.persist(course2);
		transaction.commit();
	}
	public Student load(long studentid) {
		EntityManager em = EntityManagerHelper.getCurrent();
		return em.find(Student.class, studentid);
		// for (Student student : studentlist) {
		// 	if (student.getStudentid() == studentid) {
		// 		return student;
		// 	}
		// }
		// return null;
	}
}
