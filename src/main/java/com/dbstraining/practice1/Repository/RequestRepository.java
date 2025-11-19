package com.dbstraining.practice1.Repository;

import com.dbstraining.practice1.Model.Requests;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository {
    List<Requests> findByUserId(Long userId);


    @Query("SELECT r FROM Requests r WHERE r.user.manager.id = :managerId")
    List<Requests> findRequestsByManagerId(@Param("managerId") Long managerId);

}
