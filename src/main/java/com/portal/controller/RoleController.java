package com.portal.controller;

import com.portal.model.Role;
import com.portal.repository.PermissionRepository;
import com.portal.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private  PermissionRepository permissionRepository;


    @GetMapping(value = {"/admin/role"})
    public ModelAndView login() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("rolesDefault", new Role());
        updateFacilities(modelAndView);

        modelAndView.addObject("permissionList",permissionRepository.findAll());

        return modelAndView;
    }


    @PostMapping("/admin/role/add")
    public ModelAndView greetingSubmit(@ModelAttribute Role role) {
        System.out.printf("role is " + role);
        ModelAndView modelAndView = new ModelAndView();
        roleRepository.saveAndFlush(role);
        modelAndView.setViewName("redirect:/admin/role");
        return modelAndView;
    }

    public void updateFacilities(ModelAndView modelAndView) {
        List<Role> roleList = roleRepository.findAll();

        modelAndView.addObject("roleList", roleList);
        modelAndView.addObject("filter", "roleList");
        modelAndView.setViewName("admin/role");

    }

}
