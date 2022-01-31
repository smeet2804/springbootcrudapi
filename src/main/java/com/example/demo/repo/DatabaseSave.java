package com.example.demo.repo;

import com.example.demo.models.ClgNames;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatabaseSave extends CrudRepository<ClgNames,Integer> {

    @Query("Select ud from colleges ud where lower(ud.name) like %?1%")
    public List<ClgNames> getClgByName(String name);

}
