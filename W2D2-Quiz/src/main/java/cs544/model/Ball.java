package cs544.model;

import javax.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class Ball extends Toy {
    private int Size;
}
