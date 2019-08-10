package com.mycompany.onetomanydemo.model;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 *
 * @author sakina
 */
@Entity
@Table(name = "proposal")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", length = 100)
    @NotNull
    private String title;

    @Column(name = "comment", length = 1000)
    @NotNull
    private String comment;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Personnel> personnels;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Attachments> attachments;

    public Proposal() {
    }

    public Proposal(String title, String comment, List<Personnel> personnels, List<Attachments> attachments) {
        this.title = title;
        this.comment = comment;
        this.personnels = personnels;
        this.attachments = attachments;
    }

    public Proposal(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Personnel> getPersonnels() {
        return personnels;
    }

    public void setPersonnels(List<Personnel> personnels) {
        this.personnels = personnels;
    }

    public List<Attachments> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachments> attachments) {
        this.attachments = attachments;
    }
    
    
    
    
}
