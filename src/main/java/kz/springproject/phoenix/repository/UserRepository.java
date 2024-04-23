package kz.springproject.phoenix.repository;

import jakarta.transaction.Transactional;
import kz.springproject.phoenix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
