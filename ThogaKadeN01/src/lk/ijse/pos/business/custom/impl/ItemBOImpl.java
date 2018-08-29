/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.pos.business.custom.ItemBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.impl.ItemDAOImpl;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.model.ItemDTO;

/**
 *
 * @author niroth
 */
public class ItemBOImpl implements ItemBO{

    private ItemDAO itemDAO;
    
    public ItemBOImpl(){
        this.itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    }

    public ArrayList<ItemDTO> getAllItems() throws Exception {
        ArrayList<Item> items = itemDAO.getAll();
        ArrayList<ItemDTO> dtos = new ArrayList<>();
        for (Item item : items) {
            dtos.add(new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
        }
        return dtos;
    }

    public ItemDTO searchItem(String code) throws Exception {
        Item item = itemDAO.search(code);
        return new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
    }
}
