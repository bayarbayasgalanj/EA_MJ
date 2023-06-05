package cs544;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String brand;
	private String year;
	private double price;
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner_id;

	public Car() {
	}

	public Car(String brand, String year, double price, Owner odOwner) {
		this.brand = brand;
		this.year = year;
		this.price = price;
		this.owner_id = odOwner;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public Owner getOwner_id() {
		return this.owner_id;
	}

	public void setOwner_id(Owner owner_id) {
		this.owner_id = owner_id;
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", brand='" + getBrand() + "'" +
			", year='" + getYear() + "'" +
			", price='" + getPrice() + "'" +
			", owner_id='" + getOwner_id() + "'" +
			"}";
	}

}
