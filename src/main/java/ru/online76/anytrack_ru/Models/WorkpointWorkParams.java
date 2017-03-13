/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.anytrack_ru.Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author igor
 * 
 * сущность для ведения текущего состояния заказа - изменяется отдельным модулем (модиьный телефон)
 * создана для того чтобы не затрагивать поля основной сущности рабочей точки
 * 
 */


@Entity
public class WorkpointWorkParams implements Serializable {
    
    public WorkpointWorkParams(){
        
    }
    
    public WorkpointWorkParams(Workpoint _Workpoint){
        Workpoint = _Workpoint;
    }

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "CHAR(36)")
    @Getter
    private String id;


    
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date InworkDate;
    
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date EndDate;
    
    @Getter
    @Setter
    private Workpoint.WorkStatuses WorkStatus;
    
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "Device_id", updatable = true)
    private Device Device;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Workpoint_id", insertable = true)
    @Getter
    private Workpoint Workpoint;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Coordinate_id", insertable = true)
    @Getter
    private Coordinate Coordinate=new Coordinate();
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkpointWorkParams)) {
            return false;
        }
        WorkpointWorkParams other = (WorkpointWorkParams) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.online76.anytrack_ru.Models.WorkpointWorkparams[ id=" + id + " ]";
    }
    
}
