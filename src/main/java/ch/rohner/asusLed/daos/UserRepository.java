package ch.rohner.asusLed.daos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserid(String userid);
}
