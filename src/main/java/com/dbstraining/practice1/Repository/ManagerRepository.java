package com.dbstraining.practice1.Repository;

import com.dbstraining.practice1.Model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
    Manager findByEmail(String email);
}
