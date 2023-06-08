package cs544.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence. Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence. JoinColumn;
import javax.persistence. ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;

import lombok.Getter;

@Getter
@Entity
@SecondaryTable(name="Birth")
public class Pet {
    
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String species;
    private String gender;
    
    @Column(table="Birth")
    private Date birthbate;
    
    @ManyToOne
    @JoinColumn(name="owner_id")
    private Person person;
    
    @OneToMany
    @JoinColumn (name="Pet_id")
    private List<Toy> toys = new ArrayList<Toy>();

}
