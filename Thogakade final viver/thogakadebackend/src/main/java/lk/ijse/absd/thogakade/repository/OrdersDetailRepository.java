package lk.ijse.absd.thogakade.repository;

import lk.ijse.absd.thogakade.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sandunDilhan on 8/22/2018.
 */
public interface OrdersDetailRepository extends JpaRepository<OrderDetail,String> {
}
