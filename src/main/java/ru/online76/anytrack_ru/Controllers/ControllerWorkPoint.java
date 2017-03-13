/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.online76.anytrack_ru.Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.online76.anytrack_ru.Models.Address;
import ru.online76.anytrack_ru.Models.Device;
import ru.online76.anytrack_ru.Models.Models;
import ru.online76.anytrack_ru.Models.People;
import ru.online76.anytrack_ru.Models.Workpoint;

/**
 *
 * @author igor
 */

@Controller
@SessionAttributes(value = "workpoint_edited_object")
@RequestMapping(value = "/Workpoint")
public class ControllerWorkPoint {
 
    @Autowired	private SessionFactory sessionFactory;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    
    
    
    
    private class datagrid_data{
        
        private class _footer{

            public String Phone="итого 2";
            public String Description="итого 23";
            
        }
        private class json_object{
            public String ID;
            public String Phone;
            public String Description;
            public String NewDate;
            public String PlanDate;
            public String Address;
            public String Action;
            public String ChainAction;
            public String ChainId;
            public Integer ChainOrder;
            
            
        }
        
        void LoadList(List<Workpoint> list, String ContextPath){
            
            for (Workpoint wp: list){
                json_object result = new json_object();
                result.ID = wp.getId().toString();
                result.Phone = wp.getPhone();
                result.Description = wp.getDescription();
                if (wp.getNewDate()!=null)
                result.NewDate = (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(wp.getNewDate());
                if (wp.getPlanDate()!=null)
                    result.PlanDate = (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(wp.getPlanDate());
                result.Phone = wp.getPhone();
                result.Address = wp.getAddress().toString();
                
                result.ChainId = wp.getChain_id();
                result.ChainOrder = wp.getChainOrder();
                
                result.Action = "<a href= "+ContextPath+"/Workpoint/Edit/"+wp.getId().toString()+"><img hspace=5 height=='16' width='16' src="+ContextPath+"/css/images/edit.png></a>";
                result.Action += "<a href= "+ContextPath+"/Workpoint/Cancel/"+wp.getId().toString()+"><img hspace=5 height=='16' width='16' src="+ContextPath+"/css/images/cancel.png></a>";
                result.Action += "<a href= "+ContextPath+"/Workpoint/ExcludeFromChain/"+wp.getId().toString()+"><img hspace=5 height=='16' width='16' src="+ContextPath+"/css/images/export.png></a>";
                
                
                result.ChainAction =  "<a href= "+ContextPath+"/Workpoint/Up/"  +wp.getId().toString()+"><img hspace=5 height=='16' width='16' src="+ContextPath+"/css/images/up.png></a>";
                result.ChainAction += "<a href= "+ContextPath+"/Workpoint/Down/"+wp.getId().toString()+"><img hspace=5 height=='16' width='16' src="+ContextPath+"/css/images/down.png></a>";
                result.ChainAction += "<a href= "+ContextPath+"/Workpoint/SetWorker/"+wp.getId().toString()+"><img hspace=5 height=='16' width='16' src="+ContextPath+"/css/images/autoship.png></a>";
                
                
                
              
                
                rows.add(result);
            }
            total =rows.size();
            footer.clear();
            footer.add(new _footer());
            //footer.CarName="itogo 1";
        }
        
        
        public Integer total;
        public List<json_object> rows = new  ArrayList<json_object>();
        public   List<_footer>footer=new ArrayList<_footer>();
        
        
    }
    
    @Transactional
    @RequestMapping(value="/WorkpointList")
    public String getDictionaryList(ModelMap modelMap) throws ClassNotFoundException{
        
        System.out.println("/Workзoint/WorkpointList");
        
        //org.hibernate.Criteria criteria = null;
        
        //criteria = sessionFactory.getCurrentSession().createCriteria(Workpoint.class);
        
        String viewName = "workpointList";
        /*
        List<Object> list = null;
        
        
    	//Загрузка объектов из БД
        if (criteria!=null){
            list = criteria.list();
            modelMap.addAttribute("WorkpointList", list);
            return viewName;
        }
        
       */
        
        
        return viewName;
        
    }
        
   
    @Transactional
    @RequestMapping(value = "/ListJson", headers="Accept=*/*",  produces="application/json;; charset=UTF-8")
    @ResponseBody
    public datagrid_data ListJson123412345(HttpServletRequest request) {
        
        
        org.hibernate.Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Workpoint.class);
        
    	//Загрузка объектов из БД
        List<Workpoint> list = (List<Workpoint>)criteria.addOrder( Order.asc("Chain_id") ).addOrder( Order.asc("ChainOrder") ).list();
        
        
       
        //перенос необходимых данных в массив json
        datagrid_data data = new datagrid_data();
        data.LoadList(list, request.getContextPath());
        
        
        
        return data;
    }
    
    @Transactional
    @RequestMapping(value = "/Merge", headers="Accept=*/*",  produces="application/json;; charset=UTF-8", method = RequestMethod.POST)
    //@ResponseBody
    public String Merge( @RequestBody(required=false) List<String> ids) {
        //загрузить список объектов из базы
        //пробежаться по ним и установить у них зависимости next prev и код цепочки
        //вернуть ОК
        
        
    	//Загрузка объектов из БД
        List<Workpoint> list = (List) sessionFactory.getCurrentSession().createCriteria(Workpoint.class)
                    .add(Restrictions.in("id",ids)).addOrder( Order.desc("Chain_id") ).addOrder( Order.asc("ChainOrder") ).list();
        
        Workpoint previous = null;
        
        
        String newChainGUID = java.util.UUID.randomUUID().toString();
        Integer ChainOrder = 0;
                
        for(Workpoint wp: list){
            if (previous != null){
                previous.setNextWorkpoint(wp);
                wp.setPreviousWorkpoint(previous);
            }
            wp.setChain_id(newChainGUID);
            wp.setChainOrder(ChainOrder);
            ChainOrder++;
            previous = wp;
            //System.out.println("WP: ID = "+wp.getId());
        }
        
       return "redirect:/Workpoint/WorkpointList/";
    }
    
    
    @Transactional
    @RequestMapping(value = "/SetWorker", headers="Accept=*/*",  produces="application/json;; charset=UTF-8", method = RequestMethod.POST)
    //@ResponseBody
    public String SetWorker( @RequestBody(required=false) List<String> ids) {
        //загрузить список объектов из базы
        //убедиться что они в одной цепочке.
        //если цепочки разные - выдать ошибку
        //если цепочка одинаковая - для всех объектов в этой цепочке назначить исполнителя
        //при удалении из цепочки - снимать исполнителя.
        //в 0 индексе - ID нового воркера
        String new_worker_id = ids.get(0);
        ids.remove(0);
        
        System.out.println("new worker id = "+new_worker_id+"");
        
        for(String id: ids){
            System.out.println("ids[]: "+id);
        }
        
        
        /*ProjectionList projectionList = Projections.projectionList()
        .add(Projections.countDistinct("Chain_id"));
        */
        
            // adding some criteria
        List<Object[]> results = sessionFactory.getCurrentSession().createQuery("SELECT Chain_id, count(*) from Workpoint where not Chain_id is null group by Chain_id").list();
        
        
        String Chain_id = null;
        
        
        for(Object[] result: results){
            System.out.println("result="+result+" class is "+result.getClass().toString()+" "+result[0]+" "+result[1]);
            Chain_id = (String)result[0];
            
        }
        
        if (results.size()>1){
            //ERROR - больше одной цепочки
        }
        else{
            /*
            String hql = "UPDATE Workpoint set worker id = :worker id "  + 
             "WHERE Chain_id = :Chain_id";
Query query = sessionFactory.getCurrentSession().createQuery(hql);
query.setParameter("salary", 1000);
query.setParameter("employee_id", 10);
int result = query.executeUpdate();
System.out.println("Rows affected: " + result);
            */
            
        }
        
        
        /*Integer count = (Integer)results.get(0);
        System.out.println("count : "+count);
        
        if (count==1){  //все из одной цепочки - или еще есть null цепочка
            
        }
*/
        
        
    	//Загрузка объектов из БД
        List<Workpoint> list = (List) sessionFactory.getCurrentSession().createCriteria(Workpoint.class)
                    .add(Restrictions.in("id",ids)).addOrder( Order.desc("Chain_id") ).addOrder( Order.asc("ChainOrder") ).list();
        
        
       return "redirect:/Workpoint/WorkpointList/";
    }
    
    
    
    
    
    @Transactional
    @RequestMapping(value="/ExcludeFromChain/{ObjectID}")
    public String ExcludeFromChain(@PathVariable(value = "ObjectID") String ObjectID, ModelMap modelMap){
        
        
        Workpoint wp = (Workpoint)sessionFactory.getCurrentSession().load(Workpoint.class, ObjectID);
        
        wp.ExcludeFromChain();
        
        
        return "redirect:/Workpoint/WorkpointList/";
    }
    
    
    @Transactional
    @RequestMapping(value="/Up/{ObjectID}")
    public String Up(@PathVariable(value = "ObjectID") String ObjectID, ModelMap modelMap){
        
        
        Workpoint wp = (Workpoint)sessionFactory.getCurrentSession().load(Workpoint.class, ObjectID);
        
        wp.Up();
        
        
        return "redirect:/Workpoint/WorkpointList/";
    }
    
    @Transactional
    @RequestMapping(value="/Down/{ObjectID}")
    public String Down(@PathVariable(value = "ObjectID") String ObjectID, ModelMap modelMap){
        
        
        Workpoint wp = (Workpoint)sessionFactory.getCurrentSession().load(Workpoint.class, ObjectID);
        
        wp.Down();
        
        
        return "redirect:/Workpoint/WorkpointList/";
    }
    
    
    
    
    
            
    @Transactional
    @RequestMapping(value="/DialogSelectWorker")
    public String DialogSelectWorker(ModelMap modelMap) throws ClassNotFoundException{
        
        String view_name = "dialogSelectDictionaryElement";
        
        
        System.out.println("DialogSelectWorker " );
        
        
        List<Device> list = (List) sessionFactory.getCurrentSession().createCriteria(Device.class)
                    .addOrder( Order.asc("Name") ).list();
        
        
        System.out.println("DialogSelectWorker 2" );
        modelMap.addAttribute("Device_list", list);
        
        
        modelMap.addAttribute("dictionaryModelName", Models.ModelNames.Device);

        
        
        return view_name;
    }
    
    @Transactional
    @RequestMapping(value="/Edit/{ObjectID}")
    public String editDictionaryObject(@PathVariable(value = "ObjectID") String objectID, ModelMap modelMap) throws ClassNotFoundException{
        
        String view_name = "workpointEdit";
        
        Object edited_object = sessionFactory.getCurrentSession().get(Workpoint.class, objectID);
        
        modelMap.addAttribute("workpoint_edited_object", edited_object);

        
        
        return view_name;
    }
    
    
    @Transactional
    @RequestMapping(value="/New")
    public String newDictionaryObject( ModelMap modelMap) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        String view_name = "workpointEdit";
        
        Object edited_object =  new Workpoint();
        
        modelMap.addAttribute("workpoint_edited_object", edited_object);

        
        
        return view_name;
    }
    
    
    
    
    @Transactional
    @RequestMapping(value="/Save/")
    public String saveDictionaryObject(@ModelAttribute("workpoint_edited_object") Workpoint edited_object, ModelMap modelMap){
        
        
        sessionFactory.getCurrentSession().saveOrUpdate(edited_object);
        
        return "redirect:/Workpoint/WorkpointList/";
    }
}

