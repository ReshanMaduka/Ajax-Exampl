package lk.ijse.pos.rest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import lk.ijse.pos.rest.entity.User;

public interface UserRepository extends JpaRepository<User,String> {
}
