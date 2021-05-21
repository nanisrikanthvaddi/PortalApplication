package com.portal.controller;

import com.portal.model.Facilities;
import com.portal.model.User;
import com.portal.repository.FacilityRepository;
import com.portal.repository.RoleRepository;
import com.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Timestamp;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private RoleRepository roleRepository;


    @GetMapping(value = "/admin/users")
    public ModelAndView getUsers() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", userService.getAllUsers());
        modelAndView.addObject("filter", "userList");
        modelAndView.addObject("facilityList", facilityRepository.findAll());
        modelAndView.addObject("rolesList", roleRepository.findAll());
        modelAndView.addObject("userDefault",new User());

        modelAndView.setViewName("admin/users");
        return modelAndView;
    }

    @PostMapping("/admin/users/add")
    public ModelAndView greetingSubmit(@ModelAttribute User user) {

        ModelAndView modelAndView = new ModelAndView();
        user.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
        user.setRoles(roleRepository.getOne(user.getRoles().getId()));
        user.setFacility(facilityRepository.getOne(user.getFacility().getId()));
        userService.saveUser(user);
        System.out.printf("user is "+user);
        modelAndView.setViewName("redirect:/admin/users");
        return modelAndView;
    }

}
