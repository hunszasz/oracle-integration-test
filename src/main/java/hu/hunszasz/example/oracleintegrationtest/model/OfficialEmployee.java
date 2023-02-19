package hu.hunszasz.example.oracleintegrationtest.model;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "seq_emp", initialValue = 1, allocationSize = 1)
public class OfficialEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_emp")
    private Long id;

    @OneToMany(mappedBy = "employee")
    private List<Email> emails;

    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "OfficialEmployee{" +
                "id=" + id +
                ", emails=" + emails +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
