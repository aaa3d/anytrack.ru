/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.arm_taxi_operator.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

/**
 *
 * @author igor
 */
@Entity
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long ID;

    public Long getId() {
        return ID;
    }

    public void setId(Long id) {
        this.ID = ID;
    }

    @Getter
    @Setter
    private String Mark;
    @Getter
    @Setter
    private String Color;
    @Getter
    @Setter
    private String GosNum;

    @Getter
    private int Lat;
    
    @Getter
    private int Lon;
    
    
    @Getter
    private Double Speed;

    @Getter
    @Formula(value = " case when dtLastUpdate > getdate() - 1.0/24/12 then 1 else 0 end")
    private boolean GpsActive;

    public String GetCarDescrString(boolean showSpeed) {

        String result = this.getId().toString()+" "+ this.getColor() + " " + getMark() + " " + getGosNum();
        if (showSpeed == true) {
            if (this.isGpsActive()) {
                result += String.format("%.1f км/ч", this.getSpeed());
            }
        }

        return result;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ID != null ? ID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cars)) {
            return false;
        }
        Cars other = (Cars) object;
        if ((this.ID == null && other.ID != null) || (this.ID != null && !this.ID.equals(other.ID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.online76.arm_taxi_operator.model.Car[ id=" + ID + " ]";
    }

}
