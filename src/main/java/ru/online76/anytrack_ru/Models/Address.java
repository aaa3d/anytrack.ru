/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.anytrack_ru.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author igor
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "CHAR(36)")
    
    @Getter
    private String id;
    
    @Getter
    @Setter
    private String Region;
    
    @Getter
    @Setter
    private String CityVillage;
    
    @Getter
    @Setter
    private String Street;
    
    @Getter
    @Setter
    private String House;
    
    @Getter
    @Setter
    private String AddressName;
    
        
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Coordinate_id", insertable = true)
    @Getter
    private Coordinate Coordinate=new Coordinate(this, null);
    
   
    
    

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        if (this.getRegion()!=null)
            result += this.getRegion()+" ";
        if (this.getCityVillage()!=null)
            result += this.getCityVillage()+" ";
        if (this.getStreet()!=null)
            result += this.getStreet()+" ";
        if (this.getHouse()!=null)
            result += this.getHouse()+" ";
        
        result = result.trim();
        return result;
    }
    
}
