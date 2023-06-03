package cs544;

import java.sql.*;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "cs544.Courses")
@Table(name = "courses")
public class Courses {

  @Id
  @Column(name = "\"id\"", nullable = false)
  private Integer id;
  @Column(name = "\"teacher_id\"", nullable = false)
  private Integer teacherId;
  @Column(name = "\"name\"", nullable = true)
  private String name;
}