package com.portal.service;

import com.portal.model.Role;
import com.portal.model.User;
import com.portal.repository.RoleRepository;
import com.portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Transactional
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode("password"));
        user.setActive(true);
       /* Role userRole = roleRepository.findByRoleName("ADMIN");
        user.setRoles(userRole);*/
        userRepository.save(user);
        System.out.printf("updated successfully");
        return  user;
    }

    public User updateUser(User user) {
        return userRepository.saveAndFlush(user);
    }




    public List<User> getAllUsers() {


         return userRepository.findAll();
    }

    public void deleteByUserName(User user) {

        User delUser= userRepository.findByUserName(user.getUserName());
          userRepository.deleteById(delUser.getId());
    }

}