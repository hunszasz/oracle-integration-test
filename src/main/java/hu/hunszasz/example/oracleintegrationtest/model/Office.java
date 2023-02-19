package hu.hunszasz.example.oracleintegrationtest.model;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "seq_off", initialValue = 1, allocationSize = 1, sequenceName = "seq_off")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_off")
    private Long id;

    @OneToMany(mappedBy = "office")
    private List<OfficeAddress> address;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OfficeAddress> getAddress() {
        return address;
    }

    public void setAddress(List<OfficeAddress> address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
