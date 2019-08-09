package com.mycompany.hibernatemapping.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author sakina
 */
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long student_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "prefix")
    private String prefix;

    @Column(name = "suffix")
    private String suffix;

    @Column(name = "email")
    private String email;

//    @OneToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name = "address", referencedColumnName = "add_id")
    @Embedded
    private Address address_id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "education", referencedColumnName = "edu_id")
    private Education eduction_id;

    public Student() {
    }

    public Student(String firstName, String lastName, String prefix, String suffix, String email, Address address_id, Education eduction_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.prefix = prefix;
        this.suffix = suffix;
        this.email = email;
        this.address_id = address_id;
        this.eduction_id = eduction_id;
    }

    public Address getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Address address_id) {
        this.address_id = address_id;
    }

    public Education getEduction_id() {
        return eduction_id;
    }

    public void setEduction_id(Education eduction_id) {
        this.eduction_id = eduction_id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {

        return ReflectionToStringBuilder.toString(this);
    }

}
