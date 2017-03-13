package ru.online76.arm_taxi_operator.ui_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/main")
public class ControllerMainForm {
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    // @ResponseBody
    public ModelAndView show_welcome(ModelMap modelMap) {
        System.out.println("controller_tap/welcome");

        // modelMap - заполнить данными
        // при загрузке view (jsp) - подставить их в нужные места
        // modelMap.put("value1", "занчение переменной value1");
        // return "view_tap";

        ModelAndView model1 = new ModelAndView("welcome");

        return model1;
    }
    
    
    @RequestMapping(value = "/dictionaries", method = RequestMethod.GET)
    // @ResponseBody
    public ModelAndView dictionaries(ModelMap modelMap) {
        //System.out.println("controller_tap/welcome");

        // modelMap - заполнить данными
        // при загрузке view (jsp) - подставить их в нужные места
        // modelMap.put("value1", "занчение переменной value1");
        // return "view_tap";

        ModelAndView model1 = new ModelAndView("dictionaries");

        return model1;
    }

}
