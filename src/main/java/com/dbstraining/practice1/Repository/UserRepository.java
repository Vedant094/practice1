package com.dbstraining.practice1.Repository;

import com.dbstraining.practice1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    List<User> findByManagerId(Long managerId);
}
