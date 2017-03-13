package ru.online76.anytrack_ru.Controllers;


import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.online76.anytrack_ru.Models.People;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author igor
 */
@Controller
@RequestMapping(value = "/main")
public class ControllerMain {
    
    
    @Autowired	private SessionFactory sessionFactory;
    
    
    @Transactional
    @RequestMapping(value = "/root")
    public String mainRoot(){
        System.out.println("mainRootsss");
        
        
        People people = new People();
        
                
        sessionFactory.getCurrentSession().save(people);
        
        
        
        return "main_root_page";
    }
}
