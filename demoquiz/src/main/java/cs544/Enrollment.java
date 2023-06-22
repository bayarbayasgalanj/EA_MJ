package cs544;
import jakarta.persistence.Column; import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "Grades")
public class Enrollment {
@Id
@GeneratedValue(strategy = GenerationType. IDENTITY)
private Long id;
@Column(length = 3)
private String grade;
@ManyToOne
private Student student;
@ManyToOne
private Course course;
}