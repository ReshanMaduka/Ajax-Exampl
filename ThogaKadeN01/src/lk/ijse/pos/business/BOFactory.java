/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business;

import lk.ijse.pos.business.custom.impl.CustomerBOImpl;
import lk.ijse.pos.business.custom.impl.ItemBOImpl;
import lk.ijse.pos.business.custom.impl.OrderBOImpl;

/**
 *
 * @author ranjith-suranga
 */
public class BOFactory {
    
    public enum BOTypes{
        CUSTOMER, ITEM, ORDER;
    }
    
    private static BOFactory boFactory;
    
    private BOFactory(){
        
    }
    
    public static BOFactory getInstance(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    
    public <T extends SuperBO> T getBO(BOTypes boType){
        switch(boType){
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case ITEM:
                return (T) new ItemBOImpl();
            case ORDER:
                return (T) new OrderBOImpl();
            default:
                return null;
        }
    }
    
}
