package com.example.DBdemo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class user {
    @Id
    public Integer id;

    public String name;

    public Integer age;

    @Column (name= "email_address",unique = true)
    public String email;

     /*public String getname() {
        return name;
    }*/
}
