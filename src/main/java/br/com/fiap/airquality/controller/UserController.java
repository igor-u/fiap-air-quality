package br.com.fiap.airquality.controller;

import br.com.fiap.airquality.model.user.User;
import br.com.fiap.airquality.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/air_quality")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User salvar(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public User update(@RequestBody User user){
        return userService.update(user);
    }

}