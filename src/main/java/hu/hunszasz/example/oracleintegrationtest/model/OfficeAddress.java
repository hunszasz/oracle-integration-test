package hu.hunszasz.example.oracleintegrationtest.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seq_add", initialValue = 1, allocationSize = 1)
public class OfficeAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_add")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    @Column(name = "ZIP")
    private String zipCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
