package com.portal.controller;

import com.portal.model.Permissions;

import com.portal.repository.PermissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class PermissionsController {

    @Autowired
    private PermissionRepository permissionRepository;


    @GetMapping(value = {"/admin/permissions"})
    public ModelAndView homePermissions() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permissionDefault", new Permissions());
        modelAndView.addObject("filter", "permissionsList");
        List<Permissions> permissionsList =permissionRepository.findAll();
        modelAndView.addObject("permissionsList", permissionsList);

        return modelAndView;
    }


    @PostMapping("/admin/permissions/add")
    public ModelAndView addPermissions(@ModelAttribute Permissions permissions) {
        System.out.printf("role is "  );
        ModelAndView modelAndView = new ModelAndView();
        permissionRepository.saveAndFlush(permissions);
        modelAndView.setViewName("redirect:/admin/permissions");
        return modelAndView;
    }





    }

