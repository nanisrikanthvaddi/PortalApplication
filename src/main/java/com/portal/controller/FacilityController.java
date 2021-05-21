package com.portal.controller;

import com.portal.model.Facilities;
import com.portal.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class FacilityController {

    @Autowired
    private FacilityRepository facilityRepository;


    @GetMapping(value={"/admin/facility"})
    public ModelAndView login(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("facilities", new Facilities());
        updateFacilities(modelAndView);

        return modelAndView ;
    }


    @PostMapping("/admin/facility/add")
    public ModelAndView greetingSubmit(@ModelAttribute Facilities facility) {
        System.out.printf("Facility is "+facility);
        ModelAndView modelAndView = new ModelAndView();
        facilityRepository.saveAndFlush(facility);
        updateFacilities(modelAndView);
        return modelAndView;
    }

    public void updateFacilities(ModelAndView modelAndView){
       List<Facilities> facilityList=facilityRepository.findAll();

        modelAndView.addObject("facilityList",facilityList);
        modelAndView.addObject("filter","facilityList");
        modelAndView.setViewName("admin/facility");

    }

}
