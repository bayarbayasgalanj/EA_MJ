package cs544;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;

	@OneToMany
    @JoinColumn(name="Employee_id")
    @MapKeyColumn(name="name") 
    private Set<Laptop> laptop_ids = new HashSet<>();

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addLaptop(Laptop laptop) {
        laptop_ids.add(laptop);
        laptop.setEmployee(this);
    }

    public void removeLaptop(Laptop laptop) {
        laptop_ids.remove(laptop);
        laptop.setEmployee(null);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Set<Laptop> getLaptop_ids() {
        return this.laptop_ids;
    }

    public String getLaptop_ids_names() {
        List<String> objectNames = new ArrayList<>();
        for (Laptop name : this.laptop_ids) {
            objectNames.add(name.toString());
        }
        String joinedNames = String.join(", ", objectNames);
        return joinedNames;
    }
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", laptop_ids='" + getLaptop_ids_names() + "'" +
            "}";
    }
    

}
