package co.com.poli.serviceuser.repositories;

import co.com.poli.serviceuser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsers(User user);

}