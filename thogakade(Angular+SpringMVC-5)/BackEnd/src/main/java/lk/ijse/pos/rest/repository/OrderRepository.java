package lk.ijse.pos.rest.repository;

import lk.ijse.pos.rest.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order,String> {
    @Query("SELECT count(o.id) FROM Orders o")
    long getTotalOrders();
}
