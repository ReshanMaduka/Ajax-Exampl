package lk.ijse.absd.thogakade.service;

import lk.ijse.absd.thogakade.dto.ItemDTO;

import java.util.List;

/**
 * Created by sandunDilhan on 8/21/2018.
 */
public interface ItemService {
    void saveItem(ItemDTO dto);

    void updateItem(String itemCode , ItemDTO dto);

    void deleteItem(String itemCode);

    ItemDTO findItem(String itemCode);

    List<ItemDTO> findAllItem();
}
