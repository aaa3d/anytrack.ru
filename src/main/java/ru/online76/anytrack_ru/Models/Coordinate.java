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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author igor
 */
@Entity
public class Coordinate implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    public Coordinate(){
        Address = null;
        Device = null;
    }
    
    public Coordinate(Address _Address, Device _Device){
        Address = _Address;
        
        Device = _Device;
    }
    
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "CHAR(36)")
    @Getter
    private String id;    
    
    @Getter
    @Setter
    private Integer Lat=0;
    @Getter
    @Setter
    private Integer Lon=0;
    
    
    @Getter
    @Setter
    private Date insertTm=null;
    
    @Getter
    @Setter
    private Date upateTm=null;
    
    @Getter
    @Setter
    private Integer updateCount=0;
    
    
    @OneToOne()
    @JoinColumn(name = "Address_id")
    @Getter
    private Address Address;
    
    @OneToOne()
    @JoinColumn(name = "Device_id")
    @Getter
    private Device Device;
    
    /*
    @ManyToOne()
    @JoinColumn(name = "address_id")
    @Getter
    @Setter
    private Address Address=new Address();
    */


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coordinate)) {
            return false;
        }
        Coordinate other = (Coordinate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String result="";
        if(this.getLat()!=0)
            result+=getLat()+","+getLon();
        if (this.getAddress()!=null){
            result+=" : Адрес";
        }
        return result;
    }
    
}
