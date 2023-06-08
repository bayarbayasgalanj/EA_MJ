package cs544.model;

import javax.persistence.Entity;

import lombok.Getter;

@Getter
@Entity
public class StuffedAnimal extends Toy {

    private String species;
    
}
