/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.arm_taxi_operator.ui_controller;

import ru.online76.arm_taxi_operator.JsonRequestResult;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import ru.online76.arm_taxi_operator.model.Dictionary;
import ru.online76.arm_taxi_operator.model.Operators;
import ru.online76.arm_taxi_operator.model.Orders;

/**
 *
 * @author igor
 */
@Controller
@RequestMapping(value = "/dictionary")
public class ControllerDictionary {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    MainDatabase database;

    
    @Autowired Dictionary dictionary;
    
    public ControllerDictionary() {

    }

    /*    
down vote
Try this:

@RequestMapping(value = "/test/{param1}/{param2}/{param3}")
public @ResponseBody void test(
    @RequestParam(value = "Id", required = true) String Id,
    @RequestParam(value = "maxrows", required = true) int maxrows,
    @PathVariable(value = "param1") String param1,
    @PathVariable(value = "param2") String param2,
    @PathVariable(value = "param3") String param3) {
    ...
}
     */
    
    @RequestMapping(value = "/list/{entity_name}", method = RequestMethod.GET)
    public String listElements( ModelMap model, @PathVariable(value = "entity_name") String entity_name) {
        
        if ("operator".compareTo(entity_name)==0){
            dictionary.loadModel(entity_name, true);
            model.put("dictionary", dictionary);
          
            
            return "view_dictionary";
        }
        
        
        
        return "entity_not_found";
    }
    
    
    @RequestMapping(value = "/new/{entity_name}", method = RequestMethod.GET)
    public ModelAndView newElement(@PathVariable(value = "entity_name") String entity_name) {
        return new ModelAndView("view_order", "order-entity", new Orders());
    }

    @RequestMapping(value = "/open/{entity_name}/{id}", method = RequestMethod.GET)
    public ModelAndView openElement(
            @PathVariable(value = "entity_name") String entity_name, 
            @PathVariable(value = "id") Integer id,  
            @RequestParam(required = false) Integer orderid) {
       
        ModelAndView result = new ModelAndView();
        
        if ("operator".compareTo(entity_name)==0){
            
            Operators operator = (Operators) database.get(Operators.class, id);
            
          
            
            result.setViewName("view_operator");
            result.addObject("operator", operator);
            
            return result;
        }
        
       
        return new ModelAndView("entity_not_found");
        

    }
    
    /*
    сохранение
    обработка ошибок сохранения
    вернуть json объект с кодом результата и строковым описанием для человека
    
    */
    
     
    @RequestMapping(value = "/save/operator", method = RequestMethod.GET, headers="Accept=*/*",  produces="application/json;; charset=UTF-8")
    @ResponseBody
    public JsonRequestResult saveOperator(@ModelAttribute("operator") Operators operator, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        }

        
        JsonRequestResult json_result = new JsonRequestResult("0", "SAVE_OK"); 

        System.out.println(operator.toString()+" "+operator.getFio());
        
        
        database.merge_and_save(operator);
        


        return json_result;
    } 
    


}
