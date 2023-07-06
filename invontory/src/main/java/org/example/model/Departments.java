package org.example.model;
// Generated Feb 6, 2023, 11:23:44 PM by Hibernate Tools 5.2.11.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Departments generated by hbm2java
 */
@Entity
@Table(name="departments"
    ,catalog="project1"
)
public class Departments  implements java.io.Serializable {


     private Integer id;
     private String latLong;
     private Date updateOn;
     private Date createOn;
     private String name;
     private String status;
     private Set<Employee> employees = new HashSet<Employee>(0);

    public Departments() {
    }

	
    public Departments(Date createOn, String name) {
        this.createOn = createOn;
        this.name = name;
    }
    public Departments(String latLong, Date updateOn, Date createOn, String name, String status, Set<Employee> employees) {
       this.latLong = latLong;
       this.updateOn = updateOn;
       this.createOn = createOn;
       this.name = name;
       this.status = status;
       this.employees = employees;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="latLong", length=45)
    public String getLatLong() {
        return this.latLong;
    }
    
    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="updateOn", length=10)
    public Date getUpdateOn() {
        return this.updateOn;
    }
    
    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="createOn", nullable=false, length=10)
    public Date getCreateOn() {
        return this.createOn;
    }
    
    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="status", length=45)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="departments")
    public Set<Employee> getEmployees() {
        return this.employees;
    }
    
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }




}


