package lk.ijse.pos.rest.service;

import lk.ijse.pos.rest.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemService {

    public ArrayList<ItemDTO> getAllItems();

    public ItemDTO getItem(String itemId);

    public boolean deleteItem(String itemId);

    public boolean saveItem(ItemDTO itemDTO);

    public long getTotalItems();

}
