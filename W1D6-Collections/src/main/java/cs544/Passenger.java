package cs544;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;

@Entity
public class Passenger {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@OneToMany
    @JoinColumn(name="Passenger_id")
    @OrderColumn(name="sequence")
    private List<Flight> flight_ids = new ArrayList<>();


    public Passenger(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getFlight_ids() {
        return this.flight_ids;
    }

    public void setFlight_ids(List<Flight> flight_ids) {
        this.flight_ids = flight_ids;
    }

    @Override
    public String toString() {
        return "{" +
            ", name='" + getName() + "'" +
            ", flight_ids='" + getFlight_ids() + "'" +
            "}";
    }

}

