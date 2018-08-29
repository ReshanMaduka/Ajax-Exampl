/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom;

import lk.ijse.pos.business.SuperBO;
import lk.ijse.pos.model.OrderDTO;

/**
 *
 * @author ranjith-suranga
 */
public interface OrderBO extends SuperBO{
    
    public boolean addOrder(OrderDTO order) throws Exception;
    
}
