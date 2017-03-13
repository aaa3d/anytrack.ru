/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.arm_taxi_operator.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import org.hibernate.annotations.Formula;

/**
 *
 * @author igor
 */
@Entity
@Table(name = "ORDERS")
@XmlRootElement
 

public class Order_editable implements Serializable {
    
// <editor-fold defaultstate="collapsed" desc="Основные поля - из БД">    
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "ConnectPhone")
    private String connectPhone;
    @Column(name = "AddrFrom")
    private String addrFrom;
    @Column(name = "AddrFromName")
    private String addrFromName;
    @Column(name = "HouseFrom")
    private String houseFrom;
    @Column(name = "FlatFrom")
    private String flatFrom;
    @Column(name = "AddrTo")
    private String addrTo;
    @Column(name = "AddrToName")
    private String addrToName;
    @Column(name = "ClientName")
    private String clientName;
    @Column(name = "ClientID")
    private Integer clientID;
    @Column(name = "OpID")
    private Integer opID;
    @Column(name = "OrgID")
    private Integer orgID;
    @Column(name = "ZoneID")
    private Integer zoneID;
    @Column(name = "VIP")
    private Integer vip;
    @Column(name = "ServiceID")
    private Integer serviceID;
    
    @Column(name = "Sum")
    private Integer sum;
    @Column(name = "Skidka")
    private Integer skidka;
    @Column(name = "Descr")
    private String descr;
    @Column(name = "DescrForClient")
    private String descrForClient;
    @Column(name = "Predvar")
    private Integer predvar;
    @Column(name = "dtPredvar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPredvar;
    
    @Column(name = "Lat")
    private Integer lat;
    @Column(name = "Lon")
    private Integer lon;
    
    @Column(name = "desireCarAttrib")
    private int desireCarAttrib;
    @Column(name = "fromPhone")
    private String fromPhone;
    @Column(name = "FromLine")
    private Integer fromLine;
    @Column(name = "RaionTo")
    private Integer raionTo;
    @Column(name = "HouseTo")
    private String houseTo;
    @Column(name = "OrganizationDetailID")
    private Integer organizationDetailID;
    @Column(name = "BnalMoney")
    private Integer bnalMoney;
    @Column(name = "TalonNumber")
    private String talonNumber;
    @Column(name = "AddrTo2")
    private String addrTo2;

    @Column(name = "DistanceCity")
    private Double distanceCity;
    @Column(name = "DistanceMGor")
    private Double distanceMGor;
    @Column(name = "AddrToHouse2")
    private String addrToHouse2;
    @Column(name = "DistanceMoney")
    private Double distanceMoney;
    @Column(name = "predvShowDelta")
    private Integer predvShowDelta;

    @Column(name = "is_beznal")
    private Integer isBeznal;
    
    @Column(name = "to_lat")
    private Integer toLat;
    @Column(name = "to_lon")
    private Integer toLon;
    @Column(name = "to_geopoint_moved")
    private Integer toGeopointMoved;
    @Lob
    @Column(name = "calc_path_points")
    private String calcPathPoints;
    
    
    @Column(name = "order_money")
    private Double orderMoney;
  
  
    @Column(name = "bnal_opl_tm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bnalOplTm;
    @Column(name = "order_10percent")
    private Integer order10percent;
    @Column(name = "chk_podacha")
    private Integer chkPodacha;
    @Column(name = "taxometr_enabled")
    private Integer taxometrEnabled;
    @Column(name = "OrganizationSubDetailID")
    private Integer organizationSubDetailID;
 

    public Order_editable() {
    }

    public Order_editable(Integer id) {
        this.id = id;
    }

    public Order_editable(Integer id, int desireCarAttrib, int modification) {
        this.id = id;
        this.desireCarAttrib = desireCarAttrib;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getConnectPhone() {
        return connectPhone;
    }

    public void setConnectPhone(String connectPhone) {
        this.connectPhone = connectPhone;
    }

    public String getAddrFrom() {
        return addrFrom;
    }

    public void setAddrFrom(String addrFrom) {
        this.addrFrom = addrFrom;
    }

    public String getAddrFromName() {
        return addrFromName;
    }

    public void setAddrFromName(String addrFromName) {
        this.addrFromName = addrFromName;
    }

    public String getHouseFrom() {
        return houseFrom;
    }

    public void setHouseFrom(String houseFrom) {
        this.houseFrom = houseFrom;
    }

    public String getFlatFrom() {
        return flatFrom;
    }

    public void setFlatFrom(String flatFrom) {
        this.flatFrom = flatFrom;
    }

    public String getAddrTo() {
        return addrTo;
    }

    public void setAddrTo(String addrTo) {
        this.addrTo = addrTo;
    }

    public String getAddrToName() {
        return addrToName;
    }

    public void setAddrToName(String addrToName) {
        this.addrToName = addrToName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    
    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public Integer getOpID() {
        return opID;
    }

    public void setOpID(Integer opID) {
        this.opID = opID;
    }

    public Integer getOrgID() {
        return orgID;
    }

    public void setOrgID(Integer orgID) {
        this.orgID = orgID;
    }

    public Integer getZoneID() {
        return zoneID;
    }

    public void setZoneID(Integer zoneID) {
        this.zoneID = zoneID;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getSkidka() {
        return skidka;
    }

    public void setSkidka(Integer skidka) {
        this.skidka = skidka;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getDescrForClient() {
        return descrForClient;
    }

    public void setDescrForClient(String descrForClient) {
        this.descrForClient = descrForClient;
    }

    public Integer getPredvar() {
        return predvar;
    }

    public void setPredvar(Integer predvar) {
        this.predvar = predvar;
    }

    public Date getDtPredvar() {
        return dtPredvar;
    }

    public void setDtPredvar(Date dtPredvar) {
        this.dtPredvar = dtPredvar;
    }

    

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLon() {
        return lon;
    }

    public void setLon(Integer lon) {
        this.lon = lon;
    }

    

    public int getDesireCarAttrib() {
        return desireCarAttrib;
    }

    public void setDesireCarAttrib(int desireCarAttrib) {
        this.desireCarAttrib = desireCarAttrib;
    }

    public String getFromPhone() {
        return fromPhone;
    }

    public void setFromPhone(String fromPhone) {
        this.fromPhone = fromPhone;
    }

    public Integer getFromLine() {
        return fromLine;
    }

    public void setFromLine(Integer fromLine) {
        this.fromLine = fromLine;
    }

    
    public Integer getRaionTo() {
        return raionTo;
    }

    public void setRaionTo(Integer raionTo) {
        this.raionTo = raionTo;
    }

    public String getHouseTo() {
        return houseTo;
    }

    public void setHouseTo(String houseTo) {
        this.houseTo = houseTo;
    }

    public Integer getOrganizationDetailID() {
        return organizationDetailID;
    }

    public void setOrganizationDetailID(Integer organizationDetailID) {
        this.organizationDetailID = organizationDetailID;
    }

    public Integer getBnalMoney() {
        return bnalMoney;
    }

    public void setBnalMoney(Integer bnalMoney) {
        this.bnalMoney = bnalMoney;
    }

    public String getTalonNumber() {
        return talonNumber;
    }

    public void setTalonNumber(String talonNumber) {
        this.talonNumber = talonNumber;
    }

    public String getAddrTo2() {
        return addrTo2;
    }

    public void setAddrTo2(String addrTo2) {
        this.addrTo2 = addrTo2;
    }

    public Double getDistanceCity() {
        return distanceCity;
    }

    public void setDistanceCity(Double distanceCity) {
        this.distanceCity = distanceCity;
    }

    public Double getDistanceMGor() {
        return distanceMGor;
    }

    public void setDistanceMGor(Double distanceMGor) {
        this.distanceMGor = distanceMGor;
    }

    public String getAddrToHouse2() {
        return addrToHouse2;
    }

    public void setAddrToHouse2(String addrToHouse2) {
        this.addrToHouse2 = addrToHouse2;
    }

    public Double getDistanceMoney() {
        return distanceMoney;
    }

    public void setDistanceMoney(Double distanceMoney) {
        this.distanceMoney = distanceMoney;
    }

    public Integer getPredvShowDelta() {
        return predvShowDelta;
    }

    public void setPredvShowDelta(Integer predvShowDelta) {
        this.predvShowDelta = predvShowDelta;
    }

    

    public Integer getIsBeznal() {
        return isBeznal;
    }

    public void setIsBeznal(Integer isBeznal) {
        this.isBeznal = isBeznal;
    }

    
    public Integer getToLat() {
        return toLat;
    }

    public void setToLat(Integer toLat) {
        this.toLat = toLat;
    }

    public Integer getToLon() {
        return toLon;
    }

    public void setToLon(Integer toLon) {
        this.toLon = toLon;
    }

    public Integer getToGeopointMoved() {
        return toGeopointMoved;
    }

    public void setToGeopointMoved(Integer toGeopointMoved) {
        this.toGeopointMoved = toGeopointMoved;
    }

    

    public String getCalcPathPoints() {
        return calcPathPoints;
    }

    public void setCalcPathPoints(String calcPathPoints) {
        this.calcPathPoints = calcPathPoints;
    }

    

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    


    public Date getBnalOplTm() {
        return bnalOplTm;
    }

    public void setBnalOplTm(Date bnalOplTm) {
        this.bnalOplTm = bnalOplTm;
    }



    public Integer getOrder10percent() {
        return order10percent;
    }

    public void setOrder10percent(Integer order10percent) {
        this.order10percent = order10percent;
    }


    public Integer getChkPodacha() {
        return chkPodacha;
    }

    public void setChkPodacha(Integer chkPodacha) {
        this.chkPodacha = chkPodacha;
    }


    public Integer getTaxometrEnabled() {
        return taxometrEnabled;
    }

    public void setTaxometrEnabled(Integer taxometrEnabled) {
        this.taxometrEnabled = taxometrEnabled;
    }

    public Integer getOrganizationSubDetailID() {
        return organizationSubDetailID;
    }

    public void setOrganizationSubDetailID(Integer organizationSubDetailID) {
        this.organizationSubDetailID = organizationSubDetailID;
    }


// </editor-fold>            
    
    
    
// <editor-fold defaultstate="collapsed" desc="дополнительные поля - для журнала">    
    
    
      @Getter
    @Formula(value = "dbo.format_date_delta(dtArrive, getdate())")
    private String StringTmArrive;
    
    @Formula(value = "case when predvar = 1 then dbo.format_date_delta(dtPredvar, getdate()) else '' end")
    @Getter
    private String StringTmPredvar;
    
    @Formula(value = "dbo.format_date_delta(dtBegin, getdate())")
    @Getter
    private String StringTmBegin;
    
    
    @Formula(value = "(   select cast(carid as varchar(10))+' '+cars.color+' '+cars.mark+' '+cars.gosnum+ "
            + " case when cars.dtLastUpdate > getdate()-5.0/(24*60) then "
            + "' '+cast(cars.speed as varchar(10))+' км/ч' else '' end "
            + " from cars where cars.id = carid)")
    @Getter
    private String CarDescr;
    
    
    
    public String GetTmString(){
        return this.getStringTmArrive();
    }
    
    public String GetCarString(){
        return getCarDescr();/*
        if (this.getCar()!=null){
            return this.getCar().GetCarDescrString(true);
        }
        
        return "";
*/
    }
    

    
    
    //journal functions
    
    
    
    
    public String GetAddrFromString(){
        return (getAddrFrom()+" "+getHouseFrom()+" "+getFlatFrom()).trim();
    }
    
    public String GetAddrToString(){
        return (getAddrTo()+" "+getHouseTo()).trim();
    }
    
    public String GetPhoneString(){
        return (getPhone()).trim();
    }
    
    
// </editor-fold>        
  
    public String getinerpoint1_address() {
        return "";
    }    
    public String getinerpoint1_house() {
        return "";
    }    
    public String getinerpoint1_name() {
        return "";
    }    
    public String getinerpoint2_address() {
        return "";
    }    
    public String getinerpoint2_house() {
        return "";
    }    
    public String getinerpoint2_name() {
        return "";
    }  
    public String getinerpoint3_address() {
        return "";
    }    
    public String getinerpoint3_house() {
        return "";
    }    
    public String getinerpoint3_name() {
        return "";
    }  
    public String getinerpoint4_address() {
        return "";
    }    
    public String getinerpoint4_house() {
        return "";
    }    
    public String getinerpoint4_name() {
        return "";
    }  
 

// <editor-fold defaultstate="collapsed" desc="">        
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order_editable)) {
            return false;
        }
        Order_editable other = (Order_editable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.online76.arm_taxi_operator.model.Orders[ id=" + id + " ]";
    }

// </editor-fold>        
       
    
}
