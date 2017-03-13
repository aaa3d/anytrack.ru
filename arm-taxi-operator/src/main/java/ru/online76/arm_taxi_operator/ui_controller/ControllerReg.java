/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.arm_taxi_operator.ui_controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ru.online76.arm_taxi_operator.database_controller.MainDatabase;
import ru.online76.arm_taxi_operator.model.Document;
import ru.online76.arm_taxi_operator.model.Laborant;
import ru.online76.arm_taxi_operator.model.Orders;

@Controller
//@RequestMapping(value = "/lab")
public class ControllerReg {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    MainDatabase database;

    @RequestMapping(value = "/registrator", method = RequestMethod.GET)
    public String work_orders(ModelMap modelMap) {

        ArrayList<String> timeslots = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 1, 1, 9, 0, 0);
        
        for (int i=0; i< 15; i++){
           
            timeslots.add((new SimpleDateFormat("HH:mm")).format(cal.getTime()));
            cal.add(Calendar.MINUTE, 15);
        }
        
        
        modelMap.put("timeslots", timeslots);
        return "view_registrator_work";
    }

    @RequestMapping(value = "/registrator_data_json", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json;; charset=UTF-8")
    @ResponseBody

    @Transactional
    public Laborant registrator_data_json(ModelMap modelMap) {
        Laborant laborant = null;
        Long id = 1L;
        try {
            Session session = sessionFactory.getCurrentSession();

            laborant = (Laborant) session.get(Laborant.class, id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        if (laborant != null) {
            laborant.UpdateStrings();
        }

        return laborant;

    }

    @RequestMapping(value = "/registrator_talon_close", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json;; charset=UTF-8")
    @ResponseBody

    @Transactional
    public Laborant registrator_talon_close(ModelMap modelMap, @RequestParam(required = false) Integer talon_number) {
        //отметить в базе выданый талон в текущем таймслоте
        //страница сама обновится по таймеру
        //в таблице ячейки: принятые, выданные, свободные
        //переход вперед назад по таймслотам
        
        
        
        
        
        Laborant laborant = null;
        Long id = 1L;
        try {
            Session session = sessionFactory.getCurrentSession();

            laborant = (Laborant) session.get(Laborant.class, id);
            if (laborant != null) {
                laborant.SwitchStatus();
               // session.saveOrUpdate(laborant);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        if (laborant != null) {
            laborant.UpdateStrings();
        }

        return laborant;

    }

}
