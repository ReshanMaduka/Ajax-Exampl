package lk.ijse.pos.rest.repository;

import lk.ijse.pos.rest.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item,String> {

    @Query("SELECT count(c.id) FROM Item c")
    long getTotalItems();

}
