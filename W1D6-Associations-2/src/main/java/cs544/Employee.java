package cs544;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeenumber;
	private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

	public Employee(String name) {
        this.name = name;
    }

    public long getEmployeenumber() {
        return this.employeenumber;
    }

    public void setEmployeenumber(long employeenumber) {
        this.employeenumber = employeenumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Office getOffice() {
        return this.office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "{" +
            " employeenumber='" + getEmployeenumber() + "'" +
            ", name='" + getName() + "'" +
            ", department='" + getDepartment() + "'" +
            "}";
    }

}
