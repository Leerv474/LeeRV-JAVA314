package org.lee474.demo.repository;

import org.lee474.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    List<User> findAllByUsername(String username); -> the lupa
//    User getByUsername(String username); // might be null -> not ideal
    Optional<User> findByUsername(String username);
    List<User> findByUsernameLike(String partialUsername);
}
