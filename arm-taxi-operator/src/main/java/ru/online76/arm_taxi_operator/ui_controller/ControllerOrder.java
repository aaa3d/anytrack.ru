/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.arm_taxi_operator.ui_controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import ru.online76.arm_taxi_operator.JsonRequestResult;

import ru.online76.arm_taxi_operator.database_controller.MainDatabase;
import ru.online76.arm_taxi_operator.model.Orders;

/**
 *
 * @author igor
 */
@Controller
@SessionAttributes({"edited_order"})
@RequestMapping(value = "/order")
public class ControllerOrder {
    
    @Autowired	private SessionFactory sessionFactory;
    @Autowired MainDatabase database;
	
	
    
    public ControllerOrder() {
    
    }

    //инициализация пустого объекта заказа для HTTP сессиии
    @ModelAttribute("edited_order")
    public Orders populateOrders() {
            return new Orders();
    }
  
    /*
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newOrder(){
        
        return new ModelAndView("view_order", "order-entity", new Orders());
    }
    */
    /*
    @RequestMapping(value="/person-form")
    public ModelAndView personPage() {
        return new ModelAndView("person-page", "person-entity", new Person());
    }
    */
    @Transactional
    @RequestMapping(value = "/open_dialog/{orderid}", method = RequestMethod.GET)
    public String open_dialog(Model model, @PathVariable(value = "orderid") Integer orderid){
        //ModelAndView modelAndView = new ModelAndView("dialog_edit_order");
        
        Orders edited_order = (Orders) sessionFactory.getCurrentSession().get(Orders.class, orderid);
        System.out.println("contains edited_order in cache: " + sessionFactory.getCurrentSession().contains(edited_order));
        //Orders edited_order = (Orders)database.get(Orders.class, orderid);
        
        model.addAttribute("edited_order", edited_order);
        return "dialog_edit_order";
            
    }    
    /*
    @RequestMapping(value = "/get_json_data/{orderid}", method = RequestMethod.GET, headers="Accept=* / *",  produces="application/json;; charset=UTF-8")
    @ResponseBody
    public Orders get_json_data(@PathVariable(value = "orderid") Integer orderid) {
        
        Orders order = new Orders();
        if (orderid != null){
            
            order = (Orders)database.get(Orders.class, orderid);
        }
        return order;
            
    }        
    */
    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute ("edited_order") Orders order, SessionStatus sessionStatus) {

        //ModelAndView modelAndView = new ModelAndView("dialog_edit_order");

        System.out.println("SAVE ORDER: ID = " + order.getId() + " " + order.toString() + " " + order.GetAddrFromString());
        
        System.out.println("contains order in cache: " + sessionFactory.getCurrentSession().contains(order));
        if (!sessionFactory.getCurrentSession().contains(order))
            order = (Orders)sessionFactory.getCurrentSession().merge(order);
        System.out.println("contains order in cache: " + sessionFactory.getCurrentSession().contains(order));
        

        sessionFactory.getCurrentSession().update(order);
         //sessionStatus.setComplete();
         
        //database.merge_and_save(order);
        
        return "dialog_edit_order";

    } 
    
    
   
}
