package com.team7.appointmentsystem.repository;

import com.team7.appointmentsystem.entity.Users;
import com.team7.appointmentsystem.miscellinious.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(value = "select userid,firstname,lastname,email,createdtime from users",nativeQuery = true)
    List<Map<String, Object>> findAllUsers();

    Users findByEmail(String email);

    // admin dashboard
    @Query(value = "select userid,firstname,lastname,email,createdtime from users",nativeQuery = true)
    List<Map<String,Object>> getAllUser();
  
    @Query(value = "select count(*) from users",nativeQuery = true)
    int countTotalUser();
  
    @Query(value = "select count(*) from users where cast(createdtime as Date) BETWEEN cast( ?1 as Date) and cast( ?2 as Date)",nativeQuery = true)
    int countTotalUserByThisWeek(LocalDateTime before, LocalDateTime now);
    // admin dashboard
  
    Users findByUserid(long id);

}
