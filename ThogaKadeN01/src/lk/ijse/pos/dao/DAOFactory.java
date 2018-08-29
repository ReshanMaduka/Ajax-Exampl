/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao;

import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.dao.custom.OrderDetailDAO;
import lk.ijse.pos.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.pos.dao.custom.impl.ItemDAOImpl;
import lk.ijse.pos.dao.custom.impl.OrderDAOImpl;
import lk.ijse.pos.dao.custom.impl.OrderDetailDAOImpl;

/**
 *
 * @author ranjith-suranga
 */
public class DAOFactory {
    
    public enum DAOTypes{
        CUSTOMER, ITEM, ORDER, ORDER_DETAILS;
    }
    
    private static DAOFactory dAOFactory;
    
    private DAOFactory(){
        
    }
    
    public static DAOFactory getInstance(){
        if (dAOFactory == null){
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }
    
    public <T extends SuperDAO> T getDAO(DAOTypes daoType){
        switch(daoType){
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case ITEM:
                return (T) new ItemDAOImpl();
            case ORDER_DETAILS:
                return (T) new OrderDetailDAOImpl();
            case ORDER:
                return (T) new OrderDAOImpl();
            default:
                return null;
        }
    }
    
    
}
