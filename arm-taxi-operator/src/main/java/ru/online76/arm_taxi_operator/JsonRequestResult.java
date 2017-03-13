package ru.online76.arm_taxi_operator;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author igor
 */
public class JsonRequestResult {
    
    
    
    
    
    public JsonRequestResult(String resultCode, String resultDescription){
        this.resultCode = resultCode;
        this.resultDescription = resultDescription;
    }
    
    @Getter
    @Setter
    private String resultCode="";
    
    @Getter
    @Setter
    private String resultDescription="";
    
    
    
    
}
