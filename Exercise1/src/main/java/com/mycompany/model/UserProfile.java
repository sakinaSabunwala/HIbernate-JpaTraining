/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

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
public class UserProfile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @EmbeddedId
    private UserCompositeKey userCompositeKey;
    
    @Column(name="email")
    private String email;

    public UserProfile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserCompositeKey getUserCompositeKey() {
        return userCompositeKey;
    }

    public void setUserCompositeKey(UserCompositeKey userCompositeKey) {
        this.userCompositeKey = userCompositeKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserProfile{" + "id=" + id + ", userCompositeKey=" + userCompositeKey + ", email=" + email + '}';
    }
    
  
}
