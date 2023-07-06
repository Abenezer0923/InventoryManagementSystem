package org.act.com.model;
// Generated Jul 1, 2022 4:22:39 PM by Hibernate Tools 5.2.0.Final


import java.util.Date;
import javax.persistence.*;

/**
 * Holdings generated by hbm2java
 */
@Entity
@Table(name="holdings"

)
public class Holdings  implements java.io.Serializable {


     private long idholday;
     private Employee employee;
     private Resources resources;
     private Date createdOn;
     private Date updatedOn;
     private Boolean restartstatus;

    public Holdings() {
    }

	
    public Holdings(long idholday) {
        this.idholday = idholday;
    }
    public Holdings(long idholday, Employee employee, Resources resources, Date createdOn, Date updatedOn, Boolean restartstatus) {
       this.idholday = idholday;
       this.employee = employee;
       this.resources = resources;
       this.createdOn = createdOn;
       this.updatedOn = updatedOn;
       this.restartstatus = restartstatus;
    }
   
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name="id", unique=true, nullable=false)
    
    @Column(name="idholday", unique=true, nullable=false)
    public long getIdholday() {
        return this.idholday;
    }
    
    public void setIdholday(long idholday) {
        this.idholday = idholday;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="employee")
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="resource")
    public Resources getResources() {
        return this.resources;
    }
    
    public void setResources(Resources resources) {
        this.resources = resources;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_on", length=29)
    public Date getCreatedOn() {
        return this.createdOn;
    }
    
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_on", length=29)
    public Date getUpdatedOn() {
        return this.updatedOn;
    }
    
    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    
    @Column(name="restartstatus")
    public Boolean getRestartstatus() {
        return this.restartstatus;
    }
    
    public void setRestartstatus(Boolean restartstatus) {
        this.restartstatus = restartstatus;
    }




}


