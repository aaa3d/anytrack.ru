/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.arm_taxi_operator.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author igor
 */
@Entity
@Table(name = "OPERATORS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operators.findAll", query = "SELECT o FROM Operators o"),
    @NamedQuery(name = "Operators.findById", query = "SELECT o FROM Operators o WHERE o.id = :id"),
    @NamedQuery(name = "Operators.findByPassword", query = "SELECT o FROM Operators o WHERE o.password = :password"),
    @NamedQuery(name = "Operators.findByFio", query = "SELECT o FROM Operators o WHERE o.fio = :fio"),
    @NamedQuery(name = "Operators.findByAddress", query = "SELECT o FROM Operators o WHERE o.address = :address"),
    @NamedQuery(name = "Operators.findByPhone", query = "SELECT o FROM Operators o WHERE o.phone = :phone"),
    @NamedQuery(name = "Operators.findByDescr", query = "SELECT o FROM Operators o WHERE o.descr = :descr"),
    @NamedQuery(name = "Operators.findByAccess", query = "SELECT o FROM Operators o WHERE o.access = :access"),
    @NamedQuery(name = "Operators.findByDtLastUpdate", query = "SELECT o FROM Operators o WHERE o.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "Operators.findByState", query = "SELECT o FROM Operators o WHERE o.state = :state"),
    @NamedQuery(name = "Operators.findBySpid", query = "SELECT o FROM Operators o WHERE o.spid = :spid"),
    @NamedQuery(name = "Operators.findByModification", query = "SELECT o FROM Operators o WHERE o.modification = :modification"),
    @NamedQuery(name = "Operators.findByModIndex", query = "SELECT o FROM Operators o WHERE o.modIndex = :modIndex"),
    @NamedQuery(name = "Operators.findByCcLogin", query = "SELECT o FROM Operators o WHERE o.ccLogin = :ccLogin"),
    @NamedQuery(name = "Operators.findByCcPassword", query = "SELECT o FROM Operators o WHERE o.ccPassword = :ccPassword"),
    @NamedQuery(name = "Operators.findByCcServer", query = "SELECT o FROM Operators o WHERE o.ccServer = :ccServer")})
public class Operators implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Password")
    private String password;
    @Column(name = "FIO")
    private String fio;
    @Column(name = "Address")
    private String address;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Descr")
    private String descr;
    @Column(name = "Access")
    private Integer access;
    @Basic(optional = false)
    @Column(name = "dtLastUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtLastUpdate;
    @Basic(optional = false)
    @Column(name = "State")
    private int state;
    @Column(name = "SPID")
    private Integer spid;
    @Basic(optional = false)
    @Column(name = "Modification")
    private int modification;
    @Basic(optional = false)
    @Column(name = "ModIndex")
    private int modIndex;
    @Column(name = "ccLogin")
    private String ccLogin;
    @Column(name = "ccPassword")
    private String ccPassword;
    @Column(name = "ccServer")
    private String ccServer;

    public Operators() {
    }

    public Operators(Integer id) {
        this.id = id;
    }

    public Operators(Integer id, Date dtLastUpdate, int state, int modification, int modIndex) {
        this.id = id;
        this.dtLastUpdate = dtLastUpdate;
        this.state = state;
        this.modification = modification;
        this.modIndex = modIndex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public Date getDtLastUpdate() {
        return dtLastUpdate;
    }

    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public int getModification() {
        return modification;
    }

    public void setModification(int modification) {
        this.modification = modification;
    }

    public int getModIndex() {
        return modIndex;
    }

    public void setModIndex(int modIndex) {
        this.modIndex = modIndex;
    }

    public String getCcLogin() {
        return ccLogin;
    }

    public void setCcLogin(String ccLogin) {
        this.ccLogin = ccLogin;
    }

    public String getCcPassword() {
        return ccPassword;
    }

    public void setCcPassword(String ccPassword) {
        this.ccPassword = ccPassword;
    }

    public String getCcServer() {
        return ccServer;
    }

    public void setCcServer(String ccServer) {
        this.ccServer = ccServer;
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
        if (!(object instanceof Operators)) {
            return false;
        }
        Operators other = (Operators) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.yarcloud.er76.arm_bill_edit.Operators[ id=" + id + " ]";
    }
    
}
