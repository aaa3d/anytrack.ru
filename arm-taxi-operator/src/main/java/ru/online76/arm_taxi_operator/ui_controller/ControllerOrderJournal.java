package ru.online76.arm_taxi_operator.ui_controller;

import java.util.ArrayList;
import java.util.List;

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
import ru.online76.arm_taxi_operator.model.Orders;



@Controller
@RequestMapping(value = "/order")
public class ControllerOrderJournal {
    
    private class datagrid_data{
        
        private class _footer{
            public String CarName="итого 1";
            public String Time="итого 2";
        }
        private class work_orders_json{
            public String ID;
            public String AddrFrom;
            public String AddrTo;
            public String Phone;
            public String CarName;
            public String Time;
        }
        
        void LoadOrdersList(List<Orders> list){
            
            for (Orders order: list){
                work_orders_json result = new work_orders_json();
                result.ID = order.getId().toString();
                result.AddrFrom = order.GetAddrFromString();
                result.AddrTo = order.GetAddrToString();
                result.Phone = order.GetPhoneString();
                result.Time = order.GetTmString();
                result.CarName = order.GetCarString();
                rows.add(result);
            }
            total =rows.size();
            footer.clear();
            footer.add(new _footer());
            //footer.CarName="itogo 1";
        }
        
        

        
        public Integer total;
        public List<work_orders_json> rows = new  ArrayList<work_orders_json>();
        public   List<_footer>footer=new ArrayList<_footer>();
        
        
    }
   
    

	
	//
	@Autowired	private SessionFactory sessionFactory;
	@Autowired MainDatabase database;
	
	
    @RequestMapping(value = "/work_orders", method = RequestMethod.GET)
    public String work_orders(ModelMap modelMap) {
        
    	
        
    	List<Document> docList = database.getDocumentList();

        // modelMap - заполнить данными
        // при загрузке view (jsp) - подставить их в нужные места
        // modelMap.put("value1", "занчение переменной value1");
        // return "view_tap";

        //mav.setViewName("journal");
        modelMap.addAttribute("list_documents", database.getWorkOrdersList(null, null));
        return "view_work_orders";
    }
    
    
    @RequestMapping(value = "/work_orders_json", method = RequestMethod.GET, headers="Accept=*/*",  produces="application/json;; charset=UTF-8")
    @ResponseBody
    public datagrid_data work_orders_json(@RequestParam(required = false) Integer hidden_sort_column_index, @RequestParam(required = false) String hidden_sort_column_direction, ModelMap modelMap) {
        
        
        
       
            
    	List<Orders> list = database.getWorkOrdersList(getJournalTableFieldName(hidden_sort_column_index), hidden_sort_column_direction);
       // List<work_orders_json> result_list = new  ArrayList<work_orders_json>();
        
        datagrid_data data = new datagrid_data();
        data.LoadOrdersList(list);
        
        /*
        for (Order order: list){
            work_orders_json result = new work_orders_json();
            result.ID = order.getID().toString();
            result.AddrFrom = order.GetAddrFromString();
            result.AddrTo = order.GetAddrToString();
            result.Phone = order.GetPhoneString();
            result.Time = order.GetTmString();
            result.CarName = order.GetCarString();
            
            result_list.add(result);
        }*/
        
        return data;
    }
    
    
    
    @RequestMapping(value = "/work_orders_table", method = RequestMethod.GET, produces="text/html;; charset=UTF-8")
    @ResponseBody
    public String work_orders_table(@RequestParam(required = false) Integer hidden_sort_column_index, @RequestParam(required = false) String hidden_sort_column_direction, ModelMap modelMap) {
        
        String result = "";
        
        System.out.println("Orders.getJournalTableFieldName(hidden_sort_column_index):"+getJournalTableFieldName(hidden_sort_column_index));
            
    	List<Orders> list = database.getWorkOrdersList(getJournalTableFieldName(hidden_sort_column_index), hidden_sort_column_direction);
        
        
        
        
        

        //modelMap.addAttribute("list_documents", database.getWorkOrdersList());

        result += "<table id=\"tableWorkOrders\">";
        result += "<tr>";
        result+=getJournalTableCaptionsRow();
        result += "</tr>";

        for(Orders order: list){
        result += "<tr>";
                result+= getJournalTableRow(order);
            result += "</tr>";
        }
	result += "</table>";
        
                
        
        return result;
    }
    
    
    
    
    
    
    private  String getJournalTableFieldName(Integer fieldIndex){ //0 - based
       String result = null;
       if (fieldIndex==null)
           return null;
        
       
       switch (fieldIndex){
            case 0:
                result = "AddrFrom";
                break;
            case 1:
                result = "AddrTo";
                break;
            case 2:
                result = "Phone";
                break;
            case 3:
                result = "CarID";
                break;                
            case 4:
                result = "dtPredvar";
                break;
        } 
        
        return result;
    }
    
    private  String getJournalTableCaptionsRow(){
        
        String[] captions = {"Откуда", "Куда", "Телефон", "Машина", "Время"};
        
        String result = "<thead><tr>";
        
        Integer i=0;
        for(String caption: captions){
            result +="<td onclick=switchSortColumn("+i.toString()+")>"+caption+"</td>";
            i++;
        }
        
        result += "</tr></thead>";
        
        
        return result;
    }

    private String getJournalTableRow(Orders order){
        String result = "<tr onclick=openOrder("+order.getId().toString()+")>";
        result += "<td>"+order.GetAddrFromString()+"</td>";
                result += "<td>"+order.GetAddrToString()+"</td>";
                result += "<td>"+order.GetPhoneString()+"</td>";
                result += "<td>"+order.GetCarString()+"</td>";
                result += "<td>"+order.GetTmString()+"</td>";
                
        result+="</tr>";        
    
        return result;
    }
    
    
    

}
