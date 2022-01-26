package com.example.demo.repo;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {

    @Query("Select ud from user ud where lower(ud.firstName) like %?1%")
    public List<User> getUserByName(String name);
}
