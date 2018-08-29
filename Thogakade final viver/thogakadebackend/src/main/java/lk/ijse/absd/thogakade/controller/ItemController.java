package lk.ijse.absd.thogakade.controller;

import lk.ijse.absd.thogakade.dto.ItemDTO;
import lk.ijse.absd.thogakade.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sandunDilhan on 8/22/2018.
 */
@CrossOrigin
@RestController
@RequestMapping("api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PutMapping
    public String saveItem(@RequestBody ItemDTO itemDTO){
        itemService.saveItem(itemDTO);
        return "save success";
    }

    @PostMapping(value = "/{id}")
    public String updateItem(@PathVariable("id")String itemCode,@RequestBody ItemDTO itemDTO){
        itemService.updateItem(itemCode,itemDTO);
        return "update success";
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable("id")String itemCode){
        itemService.deleteItem(itemCode);
        return "deleted Success";
    }

    @GetMapping("/{id}")
    public ItemDTO findByItem(@PathVariable("id")String itemCode){
        return itemService.findItem(itemCode);
    }

    @GetMapping
    public List<ItemDTO> getAllItem(){
        return itemService.findAllItem();
    }
}
