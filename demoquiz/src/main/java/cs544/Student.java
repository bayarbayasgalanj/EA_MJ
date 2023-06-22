package cs544;
import java.util.List;
import jakarta.persistence.Column; import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Student {
@Id
@GeneratedValue (strategy = GenerationType. IDENTITY)
@Column(name = "studentId")
private Long id;
private String name;
private int age;
@OneToMany
private List<Enrollment> Courses;
}