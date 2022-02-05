package com.example.demo.controllers;

import com.example.demo.repo.DatabaseSave;
import com.example.demo.service.ClgNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
public class apiController {

  /*  @Autowired
    private UserRepo userRepo;
   */
    @Autowired
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
    public List<Map<String,Object>> getUserName(@PathVariable String name){
      return ds.runNativeQuery(name);
   }
    @RequestMapping(path="/feedClgData")
    public void setDataInDB() throws IOException {



        cns.saveClgData();
    }


    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{

        InputStream is=file.getInputStream();
        byte data[]=new byte[is.available()];
        is.read(data);
        

        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
        //  return ResponseEntity.ok("Working");
    }

}
