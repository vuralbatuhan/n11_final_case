package com.example.n11_final_case.dao;

/*
 * @author batuhanvural
 */

import com.example.n11_final_case.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    @Query("from User ")
    List<User> getAllUser();

}
