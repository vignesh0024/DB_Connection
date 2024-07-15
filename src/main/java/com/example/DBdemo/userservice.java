package com.example.DBdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class userservice {

    @Autowired
    public userrepository userrepository;
    public String adduser(user user){
        user userdetail = user;
        userrepository.save(user);
        return "User  " + userdetail.getName()+"  added successfully";
    }

    public user getuser(Integer user_id) throws Exception {
        Optional<user> user_info = userrepository.findById(user_id);
        if (user_info.isPresent()) {
            return userrepository.getById(user_id);
        } else {
            throw new Exception("User is not available");
        }

    }

    public String deleteuser(Integer user_id) {
        user userdetail = userrepository.getById(user_id);
        if (userrepository.existsById(user_id) == true) {
            userrepository.deleteById(user_id);
            return "User  " + userdetail.getName() + "  deleted successfully";
        } else {
            return "User  " + userdetail.getName() + "  is not available";
        }
    }

   public String updateuser(Integer user_id,String email){
        Optional<user> user_info = userrepository.findById(user_id);
        user user_detail = user_info.get();
        user_detail.setEmail(email);
       userrepository.save(user_detail);
        return "Email Updated Successfully";
   }

   public List<user> findbyname(String name){
       List<user> alluser = userrepository.findAll();
       List<user>  anslist = new ArrayList<>();

       for(user each : alluser){
           if(each.getName().equals(name)){
               anslist.add(each);
           }
       }
       return anslist;
   }


}
