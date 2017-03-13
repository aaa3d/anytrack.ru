/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.arm_taxi_operator.ui_controller;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ru.online76.arm_taxi_operator.database_controller.MainDatabase;
import ru.online76.arm_taxi_operator.model.Cars;
import ru.online76.arm_taxi_operator.model.Orders;

/**
 *
 * @author igor
 */
@Controller
@RequestMapping(value = "/")
public class ControllerMap {
    
    @Autowired	private SessionFactory sessionFactory;
    @Autowired MainDatabase database;
	
	
    private class map_objects_json{
            public String ID;
            public String Name;
            public String phone;
            public String Descr;
            public String From;
            public String To;
            public String Interpoints;
            public int lat;
            public int lon;
            public String speed;
            
            
        }
    
    public ControllerMap() {
    
    }

    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public ModelAndView map(){
        return new ModelAndView("view_map");
    }
  
    
    
    
    @RequestMapping(value = "/map/get_json_objects", method = RequestMethod.GET, headers="Accept=*/*",  produces="application/json;; charset=UTF-8")
    @ResponseBody
    public List<map_objects_json> get_json_objects() {
        
        List<Cars> cars =  database.getOnlineCars();
        
        List<map_objects_json> result = new ArrayList<map_objects_json>();
        
        System.out.println("cars count: "+cars.size());
        
        for(Cars car: cars){
            map_objects_json obj = new map_objects_json();
            obj.ID = car.getId().toString();
            obj.Name = car.getColor()+" "+car.getMark()+" "+car.getGosNum();
            obj.speed = String.valueOf(car.getSpeed());
            obj.lat  = car.getLat();
            obj.lon = car.getLon();
            result.add(obj);
        }
        //sdfg
        
        return result;
            
    }        
    
    
   
}
