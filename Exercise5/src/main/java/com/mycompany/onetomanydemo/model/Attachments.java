package com.mycompany.onetomanydemo.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author sakina
 */
@Entity
@Table(name = "attachments")
public class Attachments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "filename", length = 20)
    @NotNull
    private String filename;

    @Column(name = "filesize", length = 10)
    @NotNull
    private String filesize;

    @Column(name = "created")
    @CreationTimestamp
    private LocalDateTime created;

    @Column(name = "attachment")
    @NotNull
    private byte[] attachment;

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Attachments other = (Attachments) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public Attachments() {
    }

    public Attachments(String filename, String filesize, LocalDateTime created, byte[] attachment) {
        this.filename = filename;
        this.filesize = filesize;
        this.created = created;
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    
}
