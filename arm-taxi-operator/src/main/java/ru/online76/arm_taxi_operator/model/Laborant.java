/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.arm_taxi_operator.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author igor
 */
@Entity
public class Laborant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String Name="";    
    public String current_status_string="";
    public Date status_change_time=new Date();
    public Integer current_patient_number=0;



    @Transient
    public String current_time_string;
    
    @Transient
    public String status_change_time_string;
  
    @Transient
    public String current_patient_IO;

    

    public void UpdateStrings() {

        long diff = (new Date()).getTime() - status_change_time.getTime();//as given

        long seconds = TimeUnit.MILLISECONDS.toSeconds(diff);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
        seconds = seconds  - minutes*60;

        current_time_string = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());

        
        status_change_time_string = String.format("%02d:%02d", minutes, seconds);
        //current_patient_number = "14";
        //current_patient_IO = "Василий Семенович";
    }

    public void SwitchStatus() {
        if ("Свободен".compareTo(current_status_string)==0)
            current_status_string = "Занят";
        else
            current_status_string="Свободен";
        
        status_change_time = new Date();
        
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laborant)) {
            return false;
        }
        Laborant other = (Laborant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.online76.arm_taxi_operator.model.Laborant[ id=" + id + " ]";
    }

}
