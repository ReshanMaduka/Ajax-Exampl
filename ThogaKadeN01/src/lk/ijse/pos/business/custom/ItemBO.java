/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom;

import java.util.ArrayList;
import lk.ijse.pos.business.SuperBO;
import lk.ijse.pos.model.ItemDTO;

/**
 *
 * @author ranjith-suranga
 */
public interface ItemBO extends SuperBO{
    
    public ArrayList<ItemDTO> getAllItems() throws Exception;
    
    public ItemDTO searchItem(String itemCode) throws Exception;
    
}
