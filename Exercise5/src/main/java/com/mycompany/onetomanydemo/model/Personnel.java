package com.mycompany.onetomanydemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 *
 * @author sakina
 */
@Entity
@Table(name = "personnel")
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 60)
    @NotNull
    private String name;

    @Column(name = "qualificationlevel")
    @NotNull
    private Qualifications qualifications;

    @Column(name = "phone", length = 10)
    @NotNull
    @Min(value = 10)
    @Pattern(regexp = "[9876]{1}[0-9]{9}")
    private String phone;

    public Personnel() {
    }

    public Personnel(String name, Qualifications qualifications, String phone) {
        this.name = name;
        this.qualifications = qualifications;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    
    

    

}
