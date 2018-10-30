package lk.ijse.pos.rest.controller;

import lk.ijse.pos.rest.dto.ItemDTO;
import lk.ijse.pos.rest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ItemDTO> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemDTO getItem(@PathVariable("id") String itemId){
        return itemService.getItem(itemId);
    }

    @DeleteMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteItem(String itemId){
        return itemService.deleteItem(itemId);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteItem1(@RequestParam("id") String itemId){
        return itemService.deleteItem(itemId);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveItem(@RequestBody ItemDTO itemDTO){
        return itemService.saveItem(itemDTO);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getItemsCount(){
        return itemService.getTotalItems();
    }

}
