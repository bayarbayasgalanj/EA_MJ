package cs544;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Monsters {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Level level;
    @Lob
    private String desc;
}
