package cs544;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class Payment {
    @Column(name="PAYDATE")
    private Date paydate;
    @Column(name="AMOUNT")
    private double amount;
}
