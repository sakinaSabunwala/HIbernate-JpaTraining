package com.mycompany.hibernatemapping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author sakina
 */
@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edu_id")
    private Long education_id;

    @Column(name = "degree_type")
    private String degreeType;

    @Column(name = "degree_desc")
    private String degreeDescription;

    @Column(name = "graduation_year")
    private Long graduation_year;

    @Column(name = "school")
    private String school;

    @OneToOne(mappedBy = "eduction_id")
    private Student student;

    public Education() {
    }

    public Education(String degreeType, String degreeDescription, Long graduation_year, String school) {
        this.degreeType = degreeType;
        this.degreeDescription = degreeDescription;
        this.graduation_year = graduation_year;
        this.school = school;
    }

    public Long getEducation_id() {
        return education_id;
    }

    public void setEducation_id(Long education_id) {
        this.education_id = education_id;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public String getDegreeDescription() {
        return degreeDescription;
    }

    public void setDegreeDescription(String degreeDescription) {
        this.degreeDescription = degreeDescription;
    }

    public Long getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(Long graduation_year) {
        this.graduation_year = graduation_year;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    
    
    
}
