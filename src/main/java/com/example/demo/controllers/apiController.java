package com.example.demo.controllers;

import com.example.demo.models.ClgNames;
import com.example.demo.models.User;
import com.example.demo.repo.DatabaseSave;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.ClgNameService;
import org.hibernate.dialect.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class apiController {

  /*  @Autowired
    private UserRepo userRepo;
   */ @Autowired
    private DatabaseSave ds;
    @Autowired
    private ClgNameService cns;
    @GetMapping(value="/")
    public String getPage(){
        return "Welcome";
    }

   /* @GetMapping(value="/users")
    public List<User> getUsers(){
        return  userRepo.findAll();
    }

    @PostMapping(value="/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved....";
    }

    @PutMapping(value="/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser=userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        userRepo.save(updatedUser);
        return "Updated....";
    }
    @DeleteMapping(value="/delete/{id}")
    public String deleteUser(@PathVariable long id){

        User deleteUser=userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Delete the user with user id:"+id;
    }
*/
    @GetMapping("/name/{name}")
    public List<ClgNames> getUserName(@PathVariable String name){
      return ds.getClgByName(name);
   }
    @RequestMapping(path="/feedClgData")
    public void setDataInDB() throws IOException {



        cns.saveClgData();
    }

}
