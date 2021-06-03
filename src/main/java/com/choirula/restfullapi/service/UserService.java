package com.choirula.restfullapi.service;

import com.choirula.restfullapi.model.User;
import com.choirula.restfullapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String userInsert(User user){
        User existUser = userRepository.findByEmail(user.getEmail());
        if(existUser != null){
            return "Email is exist";
        }else{
            userRepository.save(user);
            return "Success create a new user";
        }
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public String userDelete(User user){
        User userTarget = userRepository.findById(user.getId());
        if(userTarget == null){
            return "User Not Found";
        }else{
            userRepository.delete(user);
            return "user dengan id : "+user.getId()+" telah dihapus";
        }
    }

    public ResponseEntity<User> userUpdate(User user){
        User userUpdate = userRepository.findById(user.getId());
        if(userUpdate != null){
            if(user.getEmail() != null){
                user.setEmail(user.getEmail());
            }else {
                user.setEmail(userUpdate.getEmail());
            }
            if(user.getName() != null){
                user.setName(user.getName());
            }else{
                user.setName(userUpdate.getName());
            }
            if(user.getPassword() != null){
                user.setPassword(user.getPassword());
            }else{
                user.setPassword(userUpdate.getPassword());
            }
            userRepository.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
