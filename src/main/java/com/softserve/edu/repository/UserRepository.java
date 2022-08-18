package com.softserve.edu.repository;

import com.softserve.edu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    List<User> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);

    boolean existsByEmail(String email);

    Optional<List<User>> findByRoleName(String roleName);
}
