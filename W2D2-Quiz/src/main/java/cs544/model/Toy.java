package cs544.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;

@Getter
@Entity
public class Toy {

    @Id
    @GeneratedValue private int Id;
    private String description;
    
    private String material;
    
    private String color;

}
