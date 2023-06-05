package cs544;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String coursenumber;
    private String name;
    
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    public Course(){}

    public Course(String coursenumber, String name) {
        this.coursenumber = coursenumber;
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoursenumber() {
        return this.coursenumber;
    }

    public void setCoursenumber(String coursenumber) {
        this.coursenumber = coursenumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", coursenumber='" + getCoursenumber() + "'" +
            ", name='" + getName() + "'" +
            
            "}";
    }

}
