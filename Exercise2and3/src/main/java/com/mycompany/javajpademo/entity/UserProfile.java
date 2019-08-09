
package com.mycompany.javajpademo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sakina
 */
@Entity
@Table(name="user_profiles")
public class UserProfile implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
     @Column(name="name")
    private String name;
    
    @Column(name="phone")
    private Long phone;
    
    
    @Column(name="email")
    private String email;

    public UserProfile() {
    }

    public UserProfile(String name, Long phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserProfile{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + '}';
    }
    
    
}
