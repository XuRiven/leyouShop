package xuriven.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xuriven.service.pojo.User;
import xuriven.service.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public User queryUserById(@RequestParam("id")Long id){
        return this.userService.queryUserById(id);
    }
}
