package com.portal.controller;

import com.portal.model.User;
import com.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Timestamp;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

   /* @GetMapping(value={"/"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }*/

    @GetMapping(value={"/"})
    public String login(){
        return "/login";
    }

    @GetMapping(value={"/login"})
    public String login1(){

        return "/login";
    }


    @GetMapping(value="/registration")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByUserName(user.getUserName());


        if (userExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @GetMapping(value="/admin/home")
    public ModelAndView adminHome(@RequestParam(value = "module", required = false) String action){

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        if(action ==null){
            user.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
            userService.updateUser(user);
            modelAndView.addObject("userDetails",user);
        }

        if(action!=null && action.equals("users") ){
            modelAndView.addObject("userList", userService.getAllUsers());
            modelAndView.addObject("filter","userList");
        }
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }
    @GetMapping(value="/admin")
    public String adminPath(){

        return "redirect:/admin/home";
    }




}
