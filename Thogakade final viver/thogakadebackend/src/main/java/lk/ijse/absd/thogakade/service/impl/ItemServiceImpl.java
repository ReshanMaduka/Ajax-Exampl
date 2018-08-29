package lk.ijse.absd.thogakade.service.impl;

import lk.ijse.absd.thogakade.dto.ItemDTO;
import lk.ijse.absd.thogakade.entity.Item;
import lk.ijse.absd.thogakade.repository.ItemRepository;
import lk.ijse.absd.thogakade.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandunDilhan on 8/21/2018.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveItem(ItemDTO dto) {
        itemRepository.save(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateItem(String itemCode, ItemDTO dto) {
        if(!dto.getCode().equals(itemCode)){
            throw new RuntimeException("Item mismatched");
        }
        if (itemRepository.existsById(itemCode)){
            itemRepository.save(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()));
        }else{
            throw new RuntimeException("Item doesn't exist");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteItem(String itemCode) {
        if(itemRepository.existsById(itemCode)){
            itemRepository.deleteById(itemCode);
        }else{
            throw new RuntimeException("Item doesn't exist");
        }

    }

    @Override
    public ItemDTO findItem(String itemCode) {
        Item item=itemRepository.findById(itemCode).get();
        return new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
    }

    @Override
    public List<ItemDTO> findAllItem() {
        List<Item>itemList=itemRepository.findAll();
        List<ItemDTO>itemDTOList=new ArrayList<>();
        for (Item itemDTO:itemList) {
            itemDTOList.add(new ItemDTO(itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand()));
        }
        return itemDTOList;
    }
}
