package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public String listAll(Model model) {

        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers" , listUsers);

        return "users";
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {

        List<Role> listRoles = service.listRoles();

        User createdUser = new User();
        createdUser.setEnabled(true);

        model.addAttribute("createdUser" , createdUser);
        model.addAttribute("listRoles" , listRoles);

        return "user_form";
    }

    @PostMapping("users/save")
    public String saveUser (User createdUser)  {
        System.out.println(createdUser);

        service.save(createdUser);

        return "redirect:/users";
    }
}
