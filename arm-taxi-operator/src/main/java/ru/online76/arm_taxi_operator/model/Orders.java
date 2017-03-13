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
@Entity()
@Table(name = "ORDERS")
@org.hibernate.annotations.Entity(
        dynamicUpdate = true
)
@XmlRootElement
// <editor-fold defaultstate="collapsed" desc="запросы получения заказов">       
    @NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id"),
    @NamedQuery(name = "Orders.findByPhone", query = "SELECT o FROM Orders o WHERE o.phone = :phone"),
    @NamedQuery(name = "Orders.findByConnectPhone", query = "SELECT o FROM Orders o WHERE o.connectPhone = :connectPhone"),
    @NamedQuery(name = "Orders.findByAddrFrom", query = "SELECT o FROM Orders o WHERE o.addrFrom = :addrFrom"),
    @NamedQuery(name = "Orders.findByAddrFromName", query = "SELECT o FROM Orders o WHERE o.addrFromName = :addrFromName"),
    @NamedQuery(name = "Orders.findByHouseFrom", query = "SELECT o FROM Orders o WHERE o.houseFrom = :houseFrom"),
    @NamedQuery(name = "Orders.findByFlatFrom", query = "SELECT o FROM Orders o WHERE o.flatFrom = :flatFrom"),
    @NamedQuery(name = "Orders.findByAddrTo", query = "SELECT o FROM Orders o WHERE o.addrTo = :addrTo"),
    @NamedQuery(name = "Orders.findByAddrToName", query = "SELECT o FROM Orders o WHERE o.addrToName = :addrToName"),
    @NamedQuery(name = "Orders.findByClientName", query = "SELECT o FROM Orders o WHERE o.clientName = :clientName"),
    @NamedQuery(name = "Orders.findByCarID", query = "SELECT o FROM Orders o WHERE o.carID = :carID"),
    @NamedQuery(name = "Orders.findByDriverID", query = "SELECT o FROM Orders o WHERE o.driverID = :driverID"),
    @NamedQuery(name = "Orders.findByClientID", query = "SELECT o FROM Orders o WHERE o.clientID = :clientID"),
    @NamedQuery(name = "Orders.findByOpID", query = "SELECT o FROM Orders o WHERE o.opID = :opID"),
    @NamedQuery(name = "Orders.findByOrgID", query = "SELECT o FROM Orders o WHERE o.orgID = :orgID"),
    @NamedQuery(name = "Orders.findByZoneID", query = "SELECT o FROM Orders o WHERE o.zoneID = :zoneID"),
    @NamedQuery(name = "Orders.findByVip", query = "SELECT o FROM Orders o WHERE o.vip = :vip"),
    @NamedQuery(name = "Orders.findByServiceID", query = "SELECT o FROM Orders o WHERE o.serviceID = :serviceID"),
    @NamedQuery(name = "Orders.findByDtArrive", query = "SELECT o FROM Orders o WHERE o.dtArrive = :dtArrive"),
    @NamedQuery(name = "Orders.findByDtBegin", query = "SELECT o FROM Orders o WHERE o.dtBegin = :dtBegin"),
    @NamedQuery(name = "Orders.findByDtEnd", query = "SELECT o FROM Orders o WHERE o.dtEnd = :dtEnd"),
    @NamedQuery(name = "Orders.findByDtLastUpdate", query = "SELECT o FROM Orders o WHERE o.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "Orders.findBySum", query = "SELECT o FROM Orders o WHERE o.sum = :sum"),
    @NamedQuery(name = "Orders.findBySkidka", query = "SELECT o FROM Orders o WHERE o.skidka = :skidka"),
    @NamedQuery(name = "Orders.findByDescr", query = "SELECT o FROM Orders o WHERE o.descr = :descr"),
    @NamedQuery(name = "Orders.findByDescrForClient", query = "SELECT o FROM Orders o WHERE o.descrForClient = :descrForClient"),
    @NamedQuery(name = "Orders.findByPredvar", query = "SELECT o FROM Orders o WHERE o.predvar = :predvar"),
    @NamedQuery(name = "Orders.findByDtPredvar", query = "SELECT o FROM Orders o WHERE o.dtPredvar = :dtPredvar"),
    @NamedQuery(name = "Orders.findByState", query = "SELECT o FROM Orders o WHERE o.state = :state"),
    @NamedQuery(name = "Orders.findByAgreement", query = "SELECT o FROM Orders o WHERE o.agreement = :agreement"),
    @NamedQuery(name = "Orders.findByResultCode", query = "SELECT o FROM Orders o WHERE o.resultCode = :resultCode"),
    @NamedQuery(name = "Orders.findByLat", query = "SELECT o FROM Orders o WHERE o.lat = :lat"),
    @NamedQuery(name = "Orders.findByLon", query = "SELECT o FROM Orders o WHERE o.lon = :lon"),
    @NamedQuery(name = "Orders.findByTime2meet", query = "SELECT o FROM Orders o WHERE o.time2meet = :time2meet"),
    @NamedQuery(name = "Orders.findByDesireCarAttrib", query = "SELECT o FROM Orders o WHERE o.desireCarAttrib = :desireCarAttrib"),
    @NamedQuery(name = "Orders.findByFromPhone", query = "SELECT o FROM Orders o WHERE o.fromPhone = :fromPhone"),
    @NamedQuery(name = "Orders.findByFromLine", query = "SELECT o FROM Orders o WHERE o.fromLine = :fromLine"),
    @NamedQuery(name = "Orders.findByRequestAttributes", query = "SELECT o FROM Orders o WHERE o.requestAttributes = :requestAttributes"),
    @NamedQuery(name = "Orders.findByModification", query = "SELECT o FROM Orders o WHERE o.modification = :modification"),
    @NamedQuery(name = "Orders.findByRaionTo", query = "SELECT o FROM Orders o WHERE o.raionTo = :raionTo"),
    @NamedQuery(name = "Orders.findByHouseTo", query = "SELECT o FROM Orders o WHERE o.houseTo = :houseTo"),
    @NamedQuery(name = "Orders.findByOrganizationDetailID", query = "SELECT o FROM Orders o WHERE o.organizationDetailID = :organizationDetailID"),
    @NamedQuery(name = "Orders.findByBnalMoney", query = "SELECT o FROM Orders o WHERE o.bnalMoney = :bnalMoney"),
    @NamedQuery(name = "Orders.findByTalonNumber", query = "SELECT o FROM Orders o WHERE o.talonNumber = :talonNumber"),
    @NamedQuery(name = "Orders.findByAddrTo2", query = "SELECT o FROM Orders o WHERE o.addrTo2 = :addrTo2"),
    @NamedQuery(name = "Orders.findByDistanceCity", query = "SELECT o FROM Orders o WHERE o.distanceCity = :distanceCity"),
    @NamedQuery(name = "Orders.findByDistanceMGor", query = "SELECT o FROM Orders o WHERE o.distanceMGor = :distanceMGor"),
    @NamedQuery(name = "Orders.findByAddrToHouse2", query = "SELECT o FROM Orders o WHERE o.addrToHouse2 = :addrToHouse2"),
    @NamedQuery(name = "Orders.findByDistanceMoney", query = "SELECT o FROM Orders o WHERE o.distanceMoney = :distanceMoney"),
    @NamedQuery(name = "Orders.findByPredvShowDelta", query = "SELECT o FROM Orders o WHERE o.predvShowDelta = :predvShowDelta"),
    @NamedQuery(name = "Orders.findByDistribCurrentCarid", query = "SELECT o FROM Orders o WHERE o.distribCurrentCarid = :distribCurrentCarid"),
    @NamedQuery(name = "Orders.findByDistribLastTryTm", query = "SELECT o FROM Orders o WHERE o.distribLastTryTm = :distribLastTryTm"),
    @NamedQuery(name = "Orders.findByDistribStatus", query = "SELECT o FROM Orders o WHERE o.distribStatus = :distribStatus"),
    @NamedQuery(name = "Orders.findByIsBeznal", query = "SELECT o FROM Orders o WHERE o.isBeznal = :isBeznal"),
    @NamedQuery(name = "Orders.findByIsCalculated", query = "SELECT o FROM Orders o WHERE o.isCalculated = :isCalculated"),
    @NamedQuery(name = "Orders.findByFromGeopointMoved", query = "SELECT o FROM Orders o WHERE o.fromGeopointMoved = :fromGeopointMoved"),
    @NamedQuery(name = "Orders.findByToLat", query = "SELECT o FROM Orders o WHERE o.toLat = :toLat"),
    @NamedQuery(name = "Orders.findByToLon", query = "SELECT o FROM Orders o WHERE o.toLon = :toLon"),
    @NamedQuery(name = "Orders.findByToGeopointMoved", query = "SELECT o FROM Orders o WHERE o.toGeopointMoved = :toGeopointMoved"),
    @NamedQuery(name = "Orders.findByCalcCheck", query = "SELECT o FROM Orders o WHERE o.calcCheck = :calcCheck"),
    @NamedQuery(name = "Orders.findByWaitTime", query = "SELECT o FROM Orders o WHERE o.waitTime = :waitTime"),
    @NamedQuery(name = "Orders.findByBlackListMoney", query = "SELECT o FROM Orders o WHERE o.blackListMoney = :blackListMoney"),
    @NamedQuery(name = "Orders.findByBlackListCarId", query = "SELECT o FROM Orders o WHERE o.blackListCarId = :blackListCarId"),
    @NamedQuery(name = "Orders.findByTmLastCallback", query = "SELECT o FROM Orders o WHERE o.tmLastCallback = :tmLastCallback"),
    @NamedQuery(name = "Orders.findByOrderMoney", query = "SELECT o FROM Orders o WHERE o.orderMoney = :orderMoney"),
    @NamedQuery(name = "Orders.findBySmsText", query = "SELECT o FROM Orders o WHERE o.smsText = :smsText"),
    @NamedQuery(name = "Orders.findBySubStatus", query = "SELECT o FROM Orders o WHERE o.subStatus = :subStatus"),
    @NamedQuery(name = "Orders.findByTaxCityKm", query = "SELECT o FROM Orders o WHERE o.taxCityKm = :taxCityKm"),
    @NamedQuery(name = "Orders.findByTaxMgorKm", query = "SELECT o FROM Orders o WHERE o.taxMgorKm = :taxMgorKm"),
    @NamedQuery(name = "Orders.findByTaxCityWaitTime", query = "SELECT o FROM Orders o WHERE o.taxCityWaitTime = :taxCityWaitTime"),
    @NamedQuery(name = "Orders.findByTaxMgorWaitTime", query = "SELECT o FROM Orders o WHERE o.taxMgorWaitTime = :taxMgorWaitTime"),
    @NamedQuery(name = "Orders.findByTaxLastLat", query = "SELECT o FROM Orders o WHERE o.taxLastLat = :taxLastLat"),
    @NamedQuery(name = "Orders.findByTaxLastLon", query = "SELECT o FROM Orders o WHERE o.taxLastLon = :taxLastLon"),
    @NamedQuery(name = "Orders.findByTaxUslugi", query = "SELECT o FROM Orders o WHERE o.taxUslugi = :taxUslugi"),
    @NamedQuery(name = "Orders.findByTaxTarif", query = "SELECT o FROM Orders o WHERE o.taxTarif = :taxTarif"),
    @NamedQuery(name = "Orders.findByTaxLastLatTm", query = "SELECT o FROM Orders o WHERE o.taxLastLatTm = :taxLastLatTm"),
    @NamedQuery(name = "Orders.findByTaxPodachaKm", query = "SELECT o FROM Orders o WHERE o.taxPodachaKm = :taxPodachaKm"),
    @NamedQuery(name = "Orders.findByTaxPodachaTime", query = "SELECT o FROM Orders o WHERE o.taxPodachaTime = :taxPodachaTime"),
    @NamedQuery(name = "Orders.findByBnalOplTm", query = "SELECT o FROM Orders o WHERE o.bnalOplTm = :bnalOplTm"),
    @NamedQuery(name = "Orders.findByTaxMoney", query = "SELECT o FROM Orders o WHERE o.taxMoney = :taxMoney"),
    @NamedQuery(name = "Orders.findByTaxOrderWaitTime", query = "SELECT o FROM Orders o WHERE o.taxOrderWaitTime = :taxOrderWaitTime"),
    @NamedQuery(name = "Orders.findByOrder10percent", query = "SELECT o FROM Orders o WHERE o.order10percent = :order10percent"),
    @NamedQuery(name = "Orders.findByRecalcMoney", query = "SELECT o FROM Orders o WHERE o.recalcMoney = :recalcMoney"),
    @NamedQuery(name = "Orders.findByCntAutoCallback", query = "SELECT o FROM Orders o WHERE o.cntAutoCallback = :cntAutoCallback"),
    @NamedQuery(name = "Orders.findByChkPodacha", query = "SELECT o FROM Orders o WHERE o.chkPodacha = :chkPodacha"),
    @NamedQuery(name = "Orders.findByDtCreate", query = "SELECT o FROM Orders o WHERE o.dtCreate = :dtCreate"),
    @NamedQuery(name = "Orders.findByTaxometrEnabled", query = "SELECT o FROM Orders o WHERE o.taxometrEnabled = :taxometrEnabled"),
    @NamedQuery(name = "Orders.findByOrganizationSubDetailID", query = "SELECT o FROM Orders o WHERE o.organizationSubDetailID = :organizationSubDetailID"),
    @NamedQuery(name = "Orders.findByVisibleDistance", query = "SELECT o FROM Orders o WHERE o.visibleDistance = :visibleDistance"),
    @NamedQuery(name = "Orders.findByVisibleDistanceTm", query = "SELECT o FROM Orders o WHERE o.visibleDistanceTm = :visibleDistanceTm"),
    @NamedQuery(name = "Orders.findByTmDriverSetTime2meet", query = "SELECT o FROM Orders o WHERE o.tmDriverSetTime2meet = :tmDriverSetTime2meet"),
    @NamedQuery(name = "Orders.findByWebClientId", query = "SELECT o FROM Orders o WHERE o.webClientId = :webClientId"),
    @NamedQuery(name = "Orders.findByTm", query = "SELECT o FROM Orders o WHERE o.tm = :tm")})
// </editor-fold>    

public class Orders implements Serializable {
    
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
    @Column(name = "CarID")
    private Integer carID;
    @Column(name = "DriverID")
    private Integer driverID;
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
    @Column(name = "dtArrive")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtArrive;
    @Column(name = "dtBegin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtBegin;
    @Column(name = "dtEnd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEnd;
    @Column(name = "dtLastUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtLastUpdate;
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
    @Column(name = "State")
    private Integer state;
    @Column(name = "Agreement")
    private Integer agreement;
    @Column(name = "ResultCode")
    private Integer resultCode;
    @Column(name = "Lat")
    private Integer lat;
    @Column(name = "Lon")
    private Integer lon;
    @Column(name = "time2meet")
    private Integer time2meet;
    @Basic(optional = false)
    @Column(name = "desireCarAttrib")
    private int desireCarAttrib;
    @Column(name = "fromPhone")
    private String fromPhone;
    @Column(name = "FromLine")
    private Integer fromLine;
    @Column(name = "request_attributes")
    private String requestAttributes;
    @Basic(optional = false)
    @Column(name = "Modification")
    private int modification;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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
    @Column(name = "distrib_current_carid")
    private Integer distribCurrentCarid;
    @Column(name = "distrib_last_try_tm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date distribLastTryTm;
    @Column(name = "distrib_status")
    private String distribStatus;
    @Column(name = "is_beznal")
    private Integer isBeznal;
    @Column(name = "is_calculated")
    private Integer isCalculated;
    @Column(name = "from_geopoint_moved")
    private Integer fromGeopointMoved;
    @Column(name = "to_lat")
    private Integer toLat;
    @Column(name = "to_lon")
    private Integer toLon;
    @Column(name = "to_geopoint_moved")
    private Integer toGeopointMoved;
    @Column(name = "calc_check")
    private String calcCheck;
    @Lob
    @Column(name = "calc_path_points")
    private String calcPathPoints;
    @Column(name = "wait_time")
    private Double waitTime;
    @Column(name = "black_list_money")
    private Integer blackListMoney;
    @Column(name = "black_list_car_id")
    private Integer blackListCarId;
    @Column(name = "tm_last_callback")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmLastCallback;
    @Column(name = "order_money")
    private Double orderMoney;
    @Column(name = "sms_text")
    private String smsText;
    @Column(name = "sub_status")
    private Integer subStatus;
    @Column(name = "tax_city_km")
    private Double taxCityKm;
    @Column(name = "tax_mgor_km")
    private Double taxMgorKm;
    @Column(name = "tax_city_wait_time")
    private Double taxCityWaitTime;
    @Column(name = "tax_mgor_wait_time")
    private Double taxMgorWaitTime;
    @Column(name = "tax_last_lat")
    private Integer taxLastLat;
    @Column(name = "tax_last_lon")
    private Integer taxLastLon;
    @Column(name = "tax_uslugi")
    private Integer taxUslugi;
    @Column(name = "tax_tarif")
    private String taxTarif;
    @Column(name = "tax_last_lat_tm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date taxLastLatTm;
    @Column(name = "tax_podacha_km")
    private Double taxPodachaKm;
    @Column(name = "tax_podacha_time")
    private Double taxPodachaTime;
    @Column(name = "bnal_opl_tm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bnalOplTm;
    @Column(name = "tax_money")
    private Integer taxMoney;
    @Column(name = "tax_order_wait_time")
    private Integer taxOrderWaitTime;
    @Column(name = "order_10percent")
    private Integer order10percent;
    @Column(name = "recalc_money")
    private Integer recalcMoney;
    @Column(name = "cnt_auto_callback")
    private Integer cntAutoCallback;
    @Column(name = "chk_podacha")
    private Integer chkPodacha;
    @Column(name = "dtCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreate;
    @Column(name = "taxometr_enabled")
    private Integer taxometrEnabled;
    @Column(name = "OrganizationSubDetailID")
    private Integer organizationSubDetailID;
    @Column(name = "visible_distance")
    private Integer visibleDistance;
    @Column(name = "visible_distance_tm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date visibleDistanceTm;
    @Column(name = "tmDriverSetTime2meet")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmDriverSetTime2meet;
    @Column(name = "web_client_id")
    private Integer webClientId;
    @Column(name = "tm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tm;

    public Orders() {
    }

    public Orders(Integer id) {
        this.id = id;
    }

    public Orders(Integer id, int desireCarAttrib, int modification) {
        this.id = id;
        this.desireCarAttrib = desireCarAttrib;
        this.modification = modification;
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

    public Integer getCarID() {
        return carID;
    }

    public void setCarID(Integer carID) {
        this.carID = carID;
    }

    public Integer getDriverID() {
        return driverID;
    }

    public void setDriverID(Integer driverID) {
        this.driverID = driverID;
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

    public Date getDtArrive() {
        return dtArrive;
    }

    public void setDtArrive(Date dtArrive) {
        this.dtArrive = dtArrive;
    }

    public Date getDtBegin() {
        return dtBegin;
    }

    public void setDtBegin(Date dtBegin) {
        this.dtBegin = dtBegin;
    }

    public Date getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(Date dtEnd) {
        this.dtEnd = dtEnd;
    }

    public Date getDtLastUpdate() {
        return dtLastUpdate;
    }

    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAgreement() {
        return agreement;
    }

    public void setAgreement(Integer agreement) {
        this.agreement = agreement;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
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

    public Integer getTime2meet() {
        return time2meet;
    }

    public void setTime2meet(Integer time2meet) {
        this.time2meet = time2meet;
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

    public String getRequestAttributes() {
        return requestAttributes;
    }

    public void setRequestAttributes(String requestAttributes) {
        this.requestAttributes = requestAttributes;
    }

    public int getModification() {
        return modification;
    }

    public void setModification(int modification) {
        this.modification = modification;
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

    public Integer getDistribCurrentCarid() {
        return distribCurrentCarid;
    }

    public void setDistribCurrentCarid(Integer distribCurrentCarid) {
        this.distribCurrentCarid = distribCurrentCarid;
    }

    public Date getDistribLastTryTm() {
        return distribLastTryTm;
    }

    public void setDistribLastTryTm(Date distribLastTryTm) {
        this.distribLastTryTm = distribLastTryTm;
    }

    public String getDistribStatus() {
        return distribStatus;
    }

    public void setDistribStatus(String distribStatus) {
        this.distribStatus = distribStatus;
    }

    public Integer getIsBeznal() {
        return isBeznal;
    }

    public void setIsBeznal(Integer isBeznal) {
        this.isBeznal = isBeznal;
    }

    public Integer getIsCalculated() {
        return isCalculated;
    }

    public void setIsCalculated(Integer isCalculated) {
        this.isCalculated = isCalculated;
    }

    public Integer getFromGeopointMoved() {
        return fromGeopointMoved;
    }

    public void setFromGeopointMoved(Integer fromGeopointMoved) {
        this.fromGeopointMoved = fromGeopointMoved;
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

    public String getCalcCheck() {
        return calcCheck;
    }

    public void setCalcCheck(String calcCheck) {
        this.calcCheck = calcCheck;
    }

    public String getCalcPathPoints() {
        return calcPathPoints;
    }

    public void setCalcPathPoints(String calcPathPoints) {
        this.calcPathPoints = calcPathPoints;
    }

    public Double getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Double waitTime) {
        this.waitTime = waitTime;
    }

    public Integer getBlackListMoney() {
        return blackListMoney;
    }

    public void setBlackListMoney(Integer blackListMoney) {
        this.blackListMoney = blackListMoney;
    }

    public Integer getBlackListCarId() {
        return blackListCarId;
    }

    public void setBlackListCarId(Integer blackListCarId) {
        this.blackListCarId = blackListCarId;
    }

    public Date getTmLastCallback() {
        return tmLastCallback;
    }

    public void setTmLastCallback(Date tmLastCallback) {
        this.tmLastCallback = tmLastCallback;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getSmsText() {
        return smsText;
    }

    public void setSmsText(String smsText) {
        this.smsText = smsText;
    }

    public Integer getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(Integer subStatus) {
        this.subStatus = subStatus;
    }

    public Double getTaxCityKm() {
        return taxCityKm;
    }

    public void setTaxCityKm(Double taxCityKm) {
        this.taxCityKm = taxCityKm;
    }

    public Double getTaxMgorKm() {
        return taxMgorKm;
    }

    public void setTaxMgorKm(Double taxMgorKm) {
        this.taxMgorKm = taxMgorKm;
    }

    public Double getTaxCityWaitTime() {
        return taxCityWaitTime;
    }

    public void setTaxCityWaitTime(Double taxCityWaitTime) {
        this.taxCityWaitTime = taxCityWaitTime;
    }

    public Double getTaxMgorWaitTime() {
        return taxMgorWaitTime;
    }

    public void setTaxMgorWaitTime(Double taxMgorWaitTime) {
        this.taxMgorWaitTime = taxMgorWaitTime;
    }

    public Integer getTaxLastLat() {
        return taxLastLat;
    }

    public void setTaxLastLat(Integer taxLastLat) {
        this.taxLastLat = taxLastLat;
    }

    public Integer getTaxLastLon() {
        return taxLastLon;
    }

    public void setTaxLastLon(Integer taxLastLon) {
        this.taxLastLon = taxLastLon;
    }

    public Integer getTaxUslugi() {
        return taxUslugi;
    }

    public void setTaxUslugi(Integer taxUslugi) {
        this.taxUslugi = taxUslugi;
    }

    public String getTaxTarif() {
        return taxTarif;
    }

    public void setTaxTarif(String taxTarif) {
        this.taxTarif = taxTarif;
    }

    public Date getTaxLastLatTm() {
        return taxLastLatTm;
    }

    public void setTaxLastLatTm(Date taxLastLatTm) {
        this.taxLastLatTm = taxLastLatTm;
    }

    public Double getTaxPodachaKm() {
        return taxPodachaKm;
    }

    public void setTaxPodachaKm(Double taxPodachaKm) {
        this.taxPodachaKm = taxPodachaKm;
    }

    public Double getTaxPodachaTime() {
        return taxPodachaTime;
    }

    public void setTaxPodachaTime(Double taxPodachaTime) {
        this.taxPodachaTime = taxPodachaTime;
    }

    public Date getBnalOplTm() {
        return bnalOplTm;
    }

    public void setBnalOplTm(Date bnalOplTm) {
        this.bnalOplTm = bnalOplTm;
    }

    public Integer getTaxMoney() {
        return taxMoney;
    }

    public void setTaxMoney(Integer taxMoney) {
        this.taxMoney = taxMoney;
    }

    public Integer getTaxOrderWaitTime() {
        return taxOrderWaitTime;
    }

    public void setTaxOrderWaitTime(Integer taxOrderWaitTime) {
        this.taxOrderWaitTime = taxOrderWaitTime;
    }

    public Integer getOrder10percent() {
        return order10percent;
    }

    public void setOrder10percent(Integer order10percent) {
        this.order10percent = order10percent;
    }

    public Integer getRecalcMoney() {
        return recalcMoney;
    }

    public void setRecalcMoney(Integer recalcMoney) {
        this.recalcMoney = recalcMoney;
    }

    public Integer getCntAutoCallback() {
        return cntAutoCallback;
    }

    public void setCntAutoCallback(Integer cntAutoCallback) {
        this.cntAutoCallback = cntAutoCallback;
    }

    public Integer getChkPodacha() {
        return chkPodacha;
    }

    public void setChkPodacha(Integer chkPodacha) {
        this.chkPodacha = chkPodacha;
    }

    public Date getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Date dtCreate) {
        this.dtCreate = dtCreate;
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

    public Integer getVisibleDistance() {
        return visibleDistance;
    }

    public void setVisibleDistance(Integer visibleDistance) {
        this.visibleDistance = visibleDistance;
    }

    public Date getVisibleDistanceTm() {
        return visibleDistanceTm;
    }

    public void setVisibleDistanceTm(Date visibleDistanceTm) {
        this.visibleDistanceTm = visibleDistanceTm;
    }

    public Date getTmDriverSetTime2meet() {
        return tmDriverSetTime2meet;
    }

    public void setTmDriverSetTime2meet(Date tmDriverSetTime2meet) {
        this.tmDriverSetTime2meet = tmDriverSetTime2meet;
    }

    public Integer getWebClientId() {
        return webClientId;
    }

    public void setWebClientId(Integer webClientId) {
        this.webClientId = webClientId;
    }

    public Date getTm() {
        return tm;
    }

    public void setTm(Date tm) {
        this.tm = tm;
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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
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
