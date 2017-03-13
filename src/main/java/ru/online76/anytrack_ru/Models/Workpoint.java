/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.anytrack_ru.Models;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author igor
 * адрес, телефон, статус, плановая дата, реальная дата, description, sum1, sum2, sum3) - цена посещения, цена заказа, цена исполнителю
 */
@Entity
public class Workpoint implements Serializable {

    public Workpoint() {
        this.NewDate = Calendar.getInstance().getTime();
    }
    
    public static enum WorkStatuses{NEW, IN_WORK, CLOSED, CANCELLED};

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "CHAR(36)")
    
    @Getter
    private String id;
   
    @Getter
    @Setter
    private String Phone;
    
    @Getter
    @Setter
    private String Description;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address_id", updatable = true, insertable = true)
    @Getter
    @Setter
    private Address Address=new Address();
    
    @Getter
    @Setter
    private Date PlanDate;
    
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date NewDate;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WorkpointWorkParams_id", insertable = true)
    @Getter
    private WorkpointWorkParams WorkpointWorkParam=new WorkpointWorkParams(this);
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Next_id", updatable = true)
    @Getter
    @Setter
    private Workpoint NextWorkpoint;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Previous_id", updatable = true)
    @Getter
    @Setter
    private Workpoint PreviousWorkpoint;
    
    //к голове цепочки - обмен местави с парентом
    public void Up(){
        //временная переменная, т.к. она изменяется в блоке IF
        
        Workpoint _PreviousWorkpoint = PreviousWorkpoint;
        Integer _previousOrder = null;
        
        if (PreviousWorkpoint!=null){
            _previousOrder = PreviousWorkpoint.getChainOrder();
            PreviousWorkpoint.setNextWorkpoint(this.getNextWorkpoint());
            
            
            PreviousWorkpoint.setChainOrder(this.getChainOrder());
            this.setChainOrder(_previousOrder);
            
            
            this.setPreviousWorkpoint(PreviousWorkpoint.getPreviousWorkpoint());
            this.setNextWorkpoint(_PreviousWorkpoint);
        }

        
        
    }
    
    //к хвосту цепочки - обмен местави с next
    public void Down(){
        //временная переменная, т.к. она изменяется в блоке IF
        Workpoint _NextWorkpoint = NextWorkpoint;
        Integer _nextOrder = null;
        
        if (NextWorkpoint!=null){
            _nextOrder = NextWorkpoint.getChainOrder();
            NextWorkpoint.setPreviousWorkpoint(this.getPreviousWorkpoint());
            
            
            NextWorkpoint.setChainOrder(this.getChainOrder());
            this.setChainOrder(_nextOrder);
            
            this.setNextWorkpoint(NextWorkpoint.getNextWorkpoint());
            this.setPreviousWorkpoint(_NextWorkpoint);
        }

        
        
    }
    
    public void ExcludeFromChain(){
        
        if (this.getPreviousWorkpoint()!=null)
            this.getPreviousWorkpoint().setNextWorkpoint(this.getNextWorkpoint());
        if (this.getNextWorkpoint()!=null)
            this.getNextWorkpoint().setPreviousWorkpoint(this.getPreviousWorkpoint());
        
        this.setPreviousWorkpoint(null);
        this.setNextWorkpoint(null);
        this.setChain_id(null);
        this.setChainOrder(null);
    }
    

    @Column(columnDefinition = "CHAR(36)")
    @Getter
    @Setter
    private String Chain_id;
    
    @Getter
    @Setter
    private Integer ChainOrder;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workpoint)) {
            return false;
        }
        Workpoint other = (Workpoint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String result="";
        if (getPhone()!=null)
            result+= getPhone() + " ";
        
        if (getAddress()!=null)
            result+= getAddress() + " ";
        return result;
    }
    
}
