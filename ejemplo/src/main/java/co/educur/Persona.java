package co.educur;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
@Entity
@Table(name = "T_PERSON")
public class Persona {
 
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;
 
    @Column(name = "nombres", length = 64, nullable = false)
    private String fullName;
 
    @Temporal(TemporalType.DATE)
    @Column(name = "FechaNacimiento", nullable = false)
    private Date dateOfBirth;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getFullName() {
        return fullName;
    }
 
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
 
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
 
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
 
}