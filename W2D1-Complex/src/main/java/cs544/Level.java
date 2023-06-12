package cs544;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity
public class Level {
    @Id
    private long id;
    // @Lob
    // private String desc;
    // @Lob
    // private Byte descB;
    @OneToMany(mappedBy = "level")
    private List<Monsters> monsters = new ArrayList<>();
    
}
