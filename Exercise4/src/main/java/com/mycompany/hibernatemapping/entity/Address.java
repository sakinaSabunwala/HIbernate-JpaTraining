package com.mycompany.hibernatemapping.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.ws.soap.Addressing;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author sakina
 */
//@Entity
//@Table(name = "address")
@Embeddable
public class Address {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "add_id")
    
//    private Long address_id;

    @Column(name = "street1")
    private String street_1;

    @Column(name = "street2")
    private String street_2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

//    @OneToOne(mappedBy = "address_id")
//    private Student student;

    public Address() {
    }

    public Address(String street_1, String street_2, String city, String state, String country) {
        this.street_1 = street_1;
        this.street_2 = street_2;
        this.city = city;
        this.state = state;
        this.country = country;
    }

   
    public String getStreet_1() {
        return street_1;
    }

    public void setStreet_1(String street_1) {
        this.street_1 = street_1;
    }

    public String getStreet_2() {
        return street_2;
    }

    public void setStreet_2(String street_2) {
        this.street_2 = street_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

    @Override
    public String toString() {

        return ReflectionToStringBuilder.toString(this);
    }

}
