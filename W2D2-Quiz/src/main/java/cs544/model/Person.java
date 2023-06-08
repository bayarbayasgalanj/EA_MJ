package cs544.model;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence. GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;

@Getter
@Entity(name = "People")
public class Person {
    @Id
    @GeneratedValue
    private int id;
    
    private String firstname; 
    
    private String lastname;
    
    @OneToMany (mappedBy="person")
    private List<Pet> pets = new ArrayList<Pet>();
    
}
