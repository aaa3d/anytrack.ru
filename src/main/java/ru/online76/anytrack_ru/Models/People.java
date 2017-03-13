/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.anytrack_ru.Models;

import java.io.Serializable;
import java.util.HashMap;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 *
 * @author igor
 */
@Entity
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true) 

public class People implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "CHAR(36)")
    private String id;    
    
    @Getter
    @Setter
    private String Fio;
    
    @Getter
    @Setter
    private String Phone;
    
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address_id", updatable = true, insertable = true)
    @Getter
    @Setter
    private Address Address=new Address();

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        if (!(object instanceof People)) {
            return false;
        }
        People other = (People) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.online76.anytrack_ru.Models.People[ id=" + id + " ]";
    }
    
}
