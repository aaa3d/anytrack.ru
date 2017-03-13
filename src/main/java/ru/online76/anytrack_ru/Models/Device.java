/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.anytrack_ru.Models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Device implements Serializable {

    public static enum DeviceTypes { ANDROID_PHONE};
    public static enum DeviceOnlineStatuses { OFFLINE, ONLINE};
    public static enum DeviceWorkStatuses { ACTIVE, DISABLED};
    
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "CHAR(36)")
    
    @Getter
    private String id;
    
    @Getter
    @Setter
    private String Name;
    @Getter
    @Setter
    private String IMEI;
    @Getter
    @Setter
    private String AuthCode;
    
    @Getter
    @Setter
    private DeviceTypes DeviceType=Device.DeviceTypes.ANDROID_PHONE;
    
    @Getter
    @Setter
    private DeviceOnlineStatuses DeviceOnlineStatus=Device.DeviceOnlineStatuses.OFFLINE;
    
    @Getter
    @Setter
    private DeviceWorkStatuses DeviceWorkStatus=Device.DeviceWorkStatuses.ACTIVE;
    
    

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Coordinate_id", insertable = true)
    @Getter
    private Coordinate Coordinate=new Coordinate(null, this);
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        if (getName()!=null)
            result += getName()+" ";
        if (getIMEI()!=null)
            result += getIMEI()+" ";
        if (getDeviceType()!=null)
            result += getDeviceType()+" ";
        if (getDeviceOnlineStatus()!=null)
            result += getDeviceOnlineStatus()+" ";
        if (getDeviceWorkStatus()!=null)
            result += getDeviceWorkStatus()+" ";
        
        return result.trim();
    }
    
}
