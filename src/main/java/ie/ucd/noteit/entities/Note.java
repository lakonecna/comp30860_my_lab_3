package ie.ucd.noteit.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @CreationTimestamp
    @Column
    private Date created;
    @Column
    private int version;

    public Note() {}
    public Note( String title, String content, Date created, int version) {
        this.title = title;
        this.content = content;
        this.created = created;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        System.out.println("My id is " + this.id);
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        ++version;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        ++version;
    }

//    public Date getLastUpdated() {
//        return lastUpdated;
//    }
//
//    public void setLastUpdated(Date lastUpdated) { this.lastUpdated = lastUpdated; }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) { this.created = created; }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) { this.version = version; }
}
