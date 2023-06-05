package cs544;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;

@Entity
public class School {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@OneToMany
    @JoinColumn(name="School_id")
    @MapKeyColumn(name="name")
    private Map<Integer, Student> student_ids = new HashMap<>();

    public School(String name) {
        this.name = name;
        this.student_ids = new HashMap<>();
    }

    public void addStudent(Student student) {
        student_ids.put((int) student.getStudentid(), student);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer,Student> getStudent_ids() {
        return this.student_ids;
    }
    public String getStudent_ids_names() {
        List<String> objectNames = new ArrayList<>();
        for (Student name : this.student_ids.values()) {
            objectNames.add(name.toString());
        }
        String joinedNames = String.join(", ", objectNames);
        return joinedNames;
    }

    public void setStudent_ids(Map<Integer,Student> student_ids) {
        this.student_ids = student_ids;
    }

    @Override
    public String toString() {
        return "{" +
            ", name='" + getName() + "'" +
            ", student_ids='" + getStudent_ids_names() + "'" +
            "}";
    }

}
