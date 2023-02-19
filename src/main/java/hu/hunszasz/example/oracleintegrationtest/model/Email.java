package hu.hunszasz.example.oracleintegrationtest.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seq_mail", initialValue = 1, allocationSize = 1)
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mail")
    private Long id;

    private String address;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private OfficialEmployee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OfficialEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(OfficialEmployee employee) {
        this.employee = employee;
    }
}
