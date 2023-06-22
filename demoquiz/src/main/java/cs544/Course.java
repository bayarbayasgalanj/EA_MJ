package cs544;
import java.util.List;
import jakarta.persistence.Column; import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Course {
@Id
@GeneratedValue(strategy = GenerationType. IDENTITY)
private Long id;
private String name;
@Column (name = "dep", length = 2)
private String department;
private int number;
@OneToMany (mappedBy = "course")
private List<Enrollment> students;
}