package com.portal.controller;

import com.portal.model.Facility;
import com.portal.model.User;
import com.portal.repository.FacilityRepository;
import com.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@Controller

public class FacilityController {

    @Autowired
    private FacilityRepository facilityRepository;


    @GetMapping(value={"/admin/facility"})
    public ModelAndView login(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("facility", new Facility());
        updateFacilities(modelAndView);

        return modelAndView ;
    }


    @PostMapping("/admin/facility/add")
    public ModelAndView greetingSubmit(@ModelAttribute Facility facility) {
        System.out.printf("Facility is "+facility);
        ModelAndView modelAndView = new ModelAndView();
        facilityRepository.saveAndFlush(facility);
        updateFacilities(modelAndView);
        return modelAndView;
    }

    public void updateFacilities(ModelAndView modelAndView){
       List<Facility> facilityList=facilityRepository.findAll();

        modelAndView.addObject("facilityList",facilityList);
        modelAndView.addObject("filter","facilityList");
        modelAndView.setViewName("admin/facility");

    }

}
