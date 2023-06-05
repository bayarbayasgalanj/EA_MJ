package cs544;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Office {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomnumber;
    private String building;

    @OneToMany(mappedBy = "office")
    private List<Employee> employees = new ArrayList<>();

    public Office(){}

    public Office(Long roomnumber, String building) {
        this.roomnumber = roomnumber;
        this.building = building;
    }

    public Long getRoomnumber() {
        return this.roomnumber;
    }

    public void setRoomnumber(Long roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getBuilding() {
        return this.building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
