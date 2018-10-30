package lk.ijse.pos.rest.service.impl;

import lk.ijse.pos.rest.dto.ItemDTO;
import lk.ijse.pos.rest.entity.Item;
import lk.ijse.pos.rest.repository.ItemRepository;
import lk.ijse.pos.rest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ArrayList<ItemDTO> getAllItems() {
        List<Item>items=itemRepository.findAll();
        ArrayList<ItemDTO> alItems=new ArrayList<>();
        for (Item item : items) {
            ItemDTO itemDTO=new ItemDTO(item.getId(),item.getDescription(),item.getQty(),item.getPrice());
            alItems.add(itemDTO);
        }

        return alItems;

    }

    @Override
    public ItemDTO getItem(String itemId) {
        Item item=itemRepository.findById(itemId).get();
        return new ItemDTO(item.getId(),item.getDescription(),item.getQty(),item.getPrice());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteItem(String itemId) {
        itemRepository.deleteById(itemId);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveItem(ItemDTO itemDTO) {
        Item item=new Item(itemDTO.getId(),itemDTO.getDescription(),itemDTO.getQty(),itemDTO.getPrice());
        itemRepository.save(item);
        return true;
    }

    @Override
    public long getTotalItems() {
        return itemRepository.getTotalItems();
    }
}
