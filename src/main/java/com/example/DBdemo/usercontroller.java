package com.example.DBdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class usercontroller {

    @Autowired
    public  userservice userservice;

    @PostMapping("/adduser")
    public String adduser(@RequestBody user userinfo){
        return userservice.adduser(userinfo);
    }

    @GetMapping("/getuser")
    public ResponseEntity getuser(@RequestParam("user_id") Integer user_id){

        try {
            user user_detail = userservice.getuser(user_id);
            return new ResponseEntity(user_detail, HttpStatus.OK);
        }catch(Exception E){
            log.error("Error in getting user  " + E.getMessage());
            return new ResponseEntity(E.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteuser")
    public String deleteuser(@RequestParam("user_id") Integer user_id){
        return userservice.deleteuser(user_id);
    }

    @PutMapping("/updateuser")
    public String updateuser(@RequestParam("user_id") Integer user_id,@RequestParam("email") String email_id){
        return userservice.updateuser(user_id,email_id);
    }

    @GetMapping("/findbyname")
    public List<user> findbyname(@RequestParam("name") String name){
        return userservice.findbyname(name);
    }
}
