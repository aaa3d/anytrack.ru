/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.arm_taxi_operator.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import ru.online76.arm_taxi_operator.database_controller.MainDatabase;

/**
 *
 * @author igor
 */
@Controller
public class Dictionary {
    
    public class DictionaryRow{
        @Getter
        @Setter
        private int ID = 0;
        
        @Getter
        private List<String> Values = new ArrayList<String>();
    }
    
    public class DictionaryField{
        
        public DictionaryField(String name, String caption){
            Name = name;
            Caption = Caption;
        }
        @Getter
        @Setter
        private String Name = "";
        
        @Getter
        @Setter
        private String Caption = "";
    }
    
    

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    MainDatabase database;

    
    @Getter
    private String Title = "";
//    @Getter
//    private List<Method> Methods = new ArrayList<Method>();

//    @Getter
//    private List<DictionaryRow> Rows = new ArrayList<DictionaryRow>();
    
    //@Getter 
    //private List<DictionaryField> Fields = new ArrayList<DictionaryField>(); 
    
//Key=field name, value = field caption 
    @Getter 
    private LinkedHashMap<String, String> Fields = new LinkedHashMap<String, String>(); 
    

//key = ID in database, value = string array for list view
    @Getter 
    private LinkedHashMap<Integer, ArrayList<String>> Rows = new LinkedHashMap<Integer, ArrayList<String>>(); 

   
    @Getter
    private String EntityName="";

    public void loadModel(String entity_name, Boolean loadItems) {
        EntityName = entity_name;
        if (entity_name.compareTo("operator") == 0) {
            //try {
            Title = "Операторы";
            
            
            Fields.put("Fio", "Фамилия");
            Fields.put("Phone", "Телефон");
            Fields.put("Password", "Пароль");

            if (loadItems){
                for (Object item : database.getDictionaryOperatorsItems()) {
                    ArrayList<String> values = new ArrayList<String>();


                    Operators op = (Operators) item;

                    values.add(op.getFio());
                    values.add(op.getPhone());
                    values.add(op.getPassword());
                    
                    Rows.put(op.getId(), values);

                }
            }
            

        }

    }
}
