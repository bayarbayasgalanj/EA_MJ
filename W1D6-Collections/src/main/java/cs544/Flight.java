package cs544;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Flight {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String flightnumber;
    @Column(name = "`from`")
    private String fromLocation;
    @Column(name = "`to`")
    private String toLocation;
    private Date date;

    @ManyToOne
    @JoinColumn(name="Passenger_id", insertable = false, updatable = false)
    private Passenger passenger_id;



    public Flight(String flightnumber, String fromLocation, String toLocation, Date date) {
        this.flightnumber = flightnumber;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.date = date;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightnumber() {
        return this.flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public String getFromLocation() {
        return this.fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return this.toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Passenger getPassenger_id() {
        return this.passenger_id;
    }

    public void setPassenger_id(Passenger passenger_id) {
        this.passenger_id = passenger_id;
    }

    @Override
    public String toString() {
        return "{" +
            ", flightnumber='" + getFlightnumber() + "'" +
            ", fromLocation='" + getFromLocation() + "'" +
            ", toLocation='" + getToLocation() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }

}
