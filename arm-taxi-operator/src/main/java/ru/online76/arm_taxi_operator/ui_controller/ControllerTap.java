/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.online76.arm_taxi_operator.ui_controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ru.online76.arm_taxi_operator.database_controller.MainDatabase;
import ru.online76.arm_taxi_operator.model.Document;

import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author istorozhev
 * 
 *         необходимые методы: preload - формирует значения по умолчанию для
 *         нового документа verify - проводит проверки корректности заполнения
 *         полей save - сохраняет документ в базу
 */

@Controller
@RequestMapping(value="/tap")
public class ControllerTap {
	
	@Autowired MainDatabase database;
	
	
	
	public class TmpPerson {
		String Surname, Name, SecondName;

		public String getSurname() {
			return Surname;
		}

		public void setSurname(String surname) {
			Surname = surname;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public String getSecondName() {
			return SecondName;
		}

		public void setSecondName(String secondName) {
			SecondName = secondName;
		}
		
	}
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    // @ResponseBody
    public String preload(ModelMap modelMap) {
        System.out.println("controller_tap/new");
        

        // modelMap - заполнить данными
        // при загрузке view (jsp) - подставить их в нужные места
        // modelMap.put("value1", "занчение переменной value1");
        // return "view_tap";

        
        
        modelMap.addAttribute("dictionary_sex", database.getDictionaryOperatorsItems());
        modelMap.addAttribute("dictionary_work_type", database.getDictionaryWorkTypeItems());

        // .dictionary_sex.ModelAndView model1 = new ModelAndView("view_tap");

        return "view_tap";
    }

    // работающий метод
    // на входе в переменные value1 value2 попадают переменные из GET запроса
    // в ModelMap - можно записать значения для генерации jsp страницы-view
    @RequestMapping(value = "/ajax_verify", method = RequestMethod.GET, headers="Accept=*/*",  produces="application/json;; charset=UTF-8")
    @ResponseBody
    public TmpPerson verify(   WebRequest request,
                            ModelMap modelMap) {
    	
    	//t
    	//String requestEncoding = request.getCharacterEncoding();
    	
    	String NAK, VU, KKL, Surname, Name, SecondName, birthDate, Sex, Snils;
    	String Document, DocSeries, DocNumber, SMO, SRegion, SMOSeries, SMONumber;
    	String RegCountry, RegRepublic, RegArea, RegCity, RegCommunity, RegStreet, RegHouse, RegApartment, RegPhone;
    	String LivCountry, LivRepublic, LivArea, LivCity, LivCommunity, LivStreet, LivHouse, LivApartment, Location, SocCategory;
    	
    	TmpPerson Response = new TmpPerson();
    	
    	NAK				= request.getParameter("NAK");
    	VU				= request.getParameter("VU");
    	KKL				= request.getParameter("KKL");
    	Surname			= request.getParameter("Surname");
    	Name			= request.getParameter("Name");
    	SecondName		= request.getParameter("SecondName");
    	birthDate		= request.getParameter("birthDate");
    	Sex				= request.getParameter("Sex");
    	Snils			= request.getParameter("Snils");
    	Document		= request.getParameter("Document");
    	DocSeries		= request.getParameter("DocSeries");
    	DocNumber		= request.getParameter("DocNumber");
    	SMO				= request.getParameter("SMO");
    	SRegion			= request.getParameter("SRegion");
    	SMOSeries		= request.getParameter("SMOSeries");
    	SMONumber		= request.getParameter("SMONumber");
    	RegCountry		= request.getParameter("RegCountry");
    	RegRepublic		= request.getParameter("RegRepublic");
    	RegArea			= request.getParameter("RegArea");
    	RegCity			= request.getParameter("RegCity");
    	RegCommunity 	= request.getParameter("RegCommunity");
    	RegStreet		= request.getParameter("RegStreet");
    	RegHouse		= request.getParameter("RegHouse");
    	RegApartment 	= request.getParameter("RegApartment");
    	RegPhone		= request.getParameter("RegPhone");
    	LivCountry		= request.getParameter("LivCountry");
    	LivRepublic 	= request.getParameter("LivRepublic");
    	LivArea			= request.getParameter("LivArea");
    	LivCity			= request.getParameter("LivCity");
    	LivCommunity 	= request.getParameter("LivCommunity");
    	LivStreet		= request.getParameter("LivStreet");
    	LivHouse		= request.getParameter("LivHouse");
    	LivApartment 	= request.getParameter("LivApartment");
    	Location		= request.getParameter("Location");
    	SocCategory		= request.getParameter("SocCategory");
    	
        System.out.println("controller_tap/verify");    
        
        
        Document doc = new Document();
        
        doc.setAmbCardNumber(NAK);
        doc.setMedicalArea(VU);
        doc.setCodeOfPrivilege(KKL);
        
        doc.getPatient().setName(Name);
        doc.getPatient().setSurname(Surname);
        doc.getPatient().setSecondName(SecondName);
        doc.getPatient().setPhone(RegPhone);
        doc.getPatient().setBirthDate(birthDate);
        doc.getPatient().setSex(Sex);
        doc.getPatient().setSnils(Snils);
        
        
        doc.getAddress().setRegCountry(RegCountry);
        doc.getAddress().setRegRepublic(RegRepublic);
        doc.getAddress().setRegArea(RegArea);
        doc.getAddress().setRegCity(RegCity);
        doc.getAddress().setRegCommunity(RegCommunity);
        doc.getAddress().setRegStreet(RegStreet);
        doc.getAddress().setRegHouse(RegHouse);
        doc.getAddress().setRegApartment(RegApartment);
        
        
        
        
        doc.getAddress().setLivCountry(LivCountry);
        doc.getAddress().setLivRepublic(LivRepublic);
        doc.getAddress().setLivArea(LivArea);
        doc.getAddress().setLivCity(LivCity);
        doc.getAddress().setLivCommunity(LivCommunity);
        doc.getAddress().setLivStreet(LivStreet);
        doc.getAddress().setLivHouse(LivHouse);
        doc.getAddress().setLivApartment(LivApartment);
        
        doc.getPatient_document().setDocumentType(Document);
        doc.getPatient_document().setDocumentSeries(DocSeries);
        doc.getPatient_document().setDocumentNumber(DocNumber);
        
        doc.getPatient_police().setSMO(SMO);
        doc.getPatient_police().setSRegion(SRegion);
        doc.getPatient_police().setSMOSeries(SMOSeries);
        doc.getPatient_police().setSMONumber(SMONumber);
        
        
        database.save(doc);
        
        Response.setSurname(Surname);
        Response.setName(Name);
        Response.setSecondName(SecondName);
        
        return Response;
    }
    
    @RequestMapping(value = "/tap_verify", method = RequestMethod.GET)
    // @ResponseBody
    public String verify(@RequestParam(required = false) String value1, @RequestParam(required = false) String value2,
            ModelMap modelMap) {
        System.out.println("controller_tap/verify");

        
        // modelMap - заполнить данными
        // при загрузке view (jsp) - подставить их в нужные места
        modelMap.put("value2", "занчение переменной value1=" + value1);
        return "view_tap";
    }

}
