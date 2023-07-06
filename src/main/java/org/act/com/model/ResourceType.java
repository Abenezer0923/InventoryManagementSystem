package org.act.com.model;
// Generated Jul 1, 2022 4:22:39 PM by Hibernate Tools 5.2.0.Final


import java.util.Date;
import javax.persistence.*;

/**
 * ResourceType generated by hbm2java
 */
@Entity
@Table(name="resource_type"

)
public class ResourceType  implements java.io.Serializable {


     private int id;
     private Date createdOn;
     private String name;
     private Date updatedOn;

    public ResourceType() {
    }

	
    public ResourceType(int id) {
        this.id = id;
    }
    public ResourceType(int id, Date createdOn, String name, Date updatedOn) {
       this.id = id;
       this.createdOn = createdOn;
       this.name = name;
       this.updatedOn = updatedOn;
    }
   
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name="id", unique=true, nullable=false)
    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_on", length=29)
    public Date getCreatedOn() {
        return this.createdOn;
    }
    
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    
    @Column(name="name", length=200)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_on", length=29)
    public Date getUpdatedOn() {
        return this.updatedOn;
    }
    
    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }




}

