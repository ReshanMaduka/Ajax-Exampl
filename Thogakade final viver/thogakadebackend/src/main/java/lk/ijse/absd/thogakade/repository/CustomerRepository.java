package lk.ijse.absd.thogakade.repository;

import lk.ijse.absd.thogakade.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sandunDilhan on 8/21/2018.
 */
public interface CustomerRepository extends JpaRepository<Customer,String> {
}
