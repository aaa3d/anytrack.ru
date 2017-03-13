/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.anytrack_ru.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import lombok.Getter;

/**
 *
 * @author igor
 */
public class Models {
    public static enum ModelNames {None,People, Address, Device};
    public static enum FieldType {Integer, String, Memo, Dictinary, InlineDictonary};
    
    public static class FieldDesc{
        
        @Getter
        private String Name;
        
        @Getter
        private String Caption;
        
        @Getter
        private FieldType FieldType;
        
        @Getter
        private ModelNames ModelName;
        
        
        FieldDesc(String _Name, String _Caption, FieldType _FieldType, ModelNames _ModelName)
        {
            Name=_Name;
            Caption=_Caption;
            FieldType=_FieldType;
            ModelName = _ModelName;
        }
        
    }
    
    private static HashMap<ModelNames, ArrayList<FieldDesc>> ModelsDescription = new HashMap<ModelNames, ArrayList<FieldDesc>>();
    
    
    static
    {
        ArrayList<FieldDesc> PeopleFields = new ArrayList<FieldDesc>();
        PeopleFields.add(new FieldDesc("Fio", "ФИО", FieldType.String, ModelNames.None));
        PeopleFields.add(new FieldDesc("Phone", "Телефон", FieldType.String, ModelNames.None));
        PeopleFields.add(new FieldDesc("Address", "Адрес", FieldType.InlineDictonary, ModelNames.Address));
        
        
        ArrayList<FieldDesc> AddressFields = new ArrayList<FieldDesc>();
        AddressFields.add(new FieldDesc("Region", "Регион", FieldType.String, ModelNames.None));
        AddressFields.add(new FieldDesc("CityVillage", "Город/Поселок", FieldType.String, ModelNames.None));
        AddressFields.add(new FieldDesc("Street", "Улица", FieldType.String, ModelNames.None));
        AddressFields.add(new FieldDesc("House", "Дом", FieldType.String, ModelNames.None));
        AddressFields.add(new FieldDesc("AddressName", "Название", FieldType.String, ModelNames.None));
        AddressFields.add(new FieldDesc("Coordinate", "Координаты", FieldType.String, ModelNames.None));
        
        
        ArrayList<FieldDesc> DeviceFields = new ArrayList<FieldDesc>();
        DeviceFields.add(new FieldDesc("Name", "Название", FieldType.String, ModelNames.None));
        DeviceFields.add(new FieldDesc("DeviceType", "Тип устройства", FieldType.String, ModelNames.None));
        DeviceFields.add(new FieldDesc("IMEI", "IMEI", FieldType.String, ModelNames.None));
        DeviceFields.add(new FieldDesc("DeviceOnlineStatus", "Подключение", FieldType.String, ModelNames.None));
        DeviceFields.add(new FieldDesc("DeviceWorkStatus", "Активность", FieldType.String, ModelNames.None));
        DeviceFields.add(new FieldDesc("Coordinate", "Координаты", FieldType.String, ModelNames.None));
        
        
        
        
        ModelsDescription.put(ModelNames.People, PeopleFields);
        ModelsDescription.put(ModelNames.Address, AddressFields);
        ModelsDescription.put(ModelNames.Device, DeviceFields);
        
    }
    
    public static ArrayList<FieldDesc> getFieldCaptions(ModelNames entityName){
        return ModelsDescription.get(entityName);
    }
}
