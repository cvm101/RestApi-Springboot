package com.example.project01;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private  static int userCount =3;
    static {
        users.add(new User(1,"Chandu", LocalDate.now().minusYears(30)));
        users.add(new User(2,"Shivam", LocalDate.now().minusYears(32)));
        users.add(new User(3,"Istiyak", LocalDate.now().minusYears(33)));
    }

    public  List<User> findAll(){
        return users;
    }

    public User findOne(int id){
//        for(int i=0;i<users.size();i++){
//            User dummy = users.get(i);
//            if(dummy.getId()==id){
//                return users.get(i);
//            }
//        }
//        return null;
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return  users.stream().filter(predicate).findFirst().get();
    }

    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }



}
