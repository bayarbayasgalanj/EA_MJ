package cs544;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SecondaryTables;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@SecondaryTable(name="Address")
@SecondaryTables(
    @SecondaryTable(name="Address", pkJoinColumns= {
        @PrimaryKeyJoinColumn(name="PATIENT_ID", referencedColumnName="id")
})
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="NAME")
    private final String name;
    @Column(table="Address", name="STREET")
    private final String street;
    @Column(table="Address", name="ZIP")
    private final String zip;
    @Column(table="Address", name="CITY")
    private final String city;

}
