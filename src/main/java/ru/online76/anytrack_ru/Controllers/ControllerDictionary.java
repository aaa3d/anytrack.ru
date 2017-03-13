/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.anytrack_ru.Controllers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.online76.anytrack_ru.Models.Address;
import ru.online76.anytrack_ru.Models.Models;
import ru.online76.anytrack_ru.Models.People;

/**
 *
 * @author igor
 */

@Controller
@SessionAttributes(value = "dictionary_edited_object")
@RequestMapping(value = "/Dictionary")
public class ControllerDictionary {
 
    @Autowired	private SessionFactory sessionFactory;
    
    
    
    
    //not used
    private class datagrid_data{
        
        
        private class json_object{
            public String id;
            public String StringDescr;
        }
        
        void LoadList(List<Object> list) throws IllegalAccessException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException{
            
            Method getidMethod = null;
            
            
            for (Object object: list){
                if (getidMethod == null){
                
                    getidMethod = object.getClass().getMethod("getId");
                }
                
                json_object result = new json_object();
                
               
                
                result.id = ((String)  getidMethod.invoke(object));
                result.StringDescr = object.toString();
                
                
               
                rows.add(result);
            }
            
        }
        
        

        

        public List<json_object> rows = new  ArrayList<json_object>();

        
        
    }
    
    @Transactional
    @RequestMapping(value="/List/{EntityName}")
    public String getDictionaryList(@PathVariable("EntityName") Models.ModelNames modelName, ModelMap modelMap) throws ClassNotFoundException{
        
        System.out.println("/Dictionary/List/"+modelName);
        org.hibernate.Criteria criteria = null;
        
        criteria = sessionFactory.getCurrentSession().createCriteria(Class.forName("ru.online76.anytrack_ru.Models."+modelName.toString()));
        String viewName = "dictionaryList";
        List<Object> list = null;
        
        
    	//Загрузка объектов из БД
        if (criteria!=null){
            list = criteria.list();
            modelMap.addAttribute("dictionaryList", list);
            modelMap.addAttribute("dictionaryListFields", Models.getFieldCaptions(modelName));
            modelMap.addAttribute("dictionaryModelName", modelName.toString());
            
            return viewName;
        }
        return "system_error";
        
    }
    
   
    @Transactional
    @RequestMapping(value = "/ListForSelect/{modelName}", headers="Accept=*/*",  produces="application/json;; charset=UTF-8")
    @ResponseBody
    public datagrid_data ListForSelect(@PathVariable("modelName") Models.ModelNames modelName, ModelMap modelMap) throws IllegalAccessException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        
        System.out.println("ListForSelect " +modelName);
        org.hibernate.Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Class.forName("ru.online76.anytrack_ru.Models."+modelName.toString()));
        
    	//Загрузка объектов из БД
        List<Object> list = (List<Object>)criteria.list();
        

        
        
       
        //перенос необходимых данных в массив json
        datagrid_data data = new datagrid_data();
        data.LoadList(list);
        
        
        return data;
    }
    
    @Transactional
    @RequestMapping(value="/Edit/{modelName}/{ObjectID}")
    public String editDictionaryObject(@PathVariable(value = "ObjectID") String objectID, @PathVariable("modelName") Models.ModelNames modelName,  ModelMap modelMap) throws ClassNotFoundException{
        
        String view_name = "dictionaryEdit"+modelName;
        
        Object edited_object = sessionFactory.getCurrentSession().get(Class.forName("ru.online76.anytrack_ru.Models."+modelName.toString()), objectID);
        
        modelMap.addAttribute("dictionary_edited_object", edited_object);

        modelMap.addAttribute("dictionaryListFields", Models.getFieldCaptions(modelName));
        modelMap.addAttribute("dictionaryModelName", modelName.toString());
        
        return view_name;
    }
    
    
    @Transactional
    @RequestMapping(value="/New/{modelName}")
    public String newDictionaryObject(@PathVariable("modelName") Models.ModelNames modelName,  ModelMap modelMap) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        String view_name = "dictionaryEdit"+modelName;
        
        Object edited_object =  (Class.forName("ru.online76.anytrack_ru.Models."+modelName.toString())).newInstance();
        
        modelMap.addAttribute("dictionary_edited_object", edited_object);

        modelMap.addAttribute("dictionaryListFields", Models.getFieldCaptions(modelName));
        modelMap.addAttribute("dictionaryModelName", modelName.toString());
        
        return view_name;
    }
    
    
    
    @Transactional
    @RequestMapping(value="/Save/{modelName}")
    public String saveDictionaryObject(@ModelAttribute("dictionary_edited_object") Object edited_object, @PathVariable("modelName") Models.ModelNames modelName, ModelMap modelMap){
        
        
        sessionFactory.getCurrentSession().saveOrUpdate(edited_object);
        
        return "redirect:/Dictionary/List/"+modelName;
        
    }
}

