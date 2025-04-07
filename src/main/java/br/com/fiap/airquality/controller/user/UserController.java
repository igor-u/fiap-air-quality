package br.com.fiap.airquality.controller.user;

import br.com.fiap.airquality.domain.user.User;
import br.com.fiap.airquality.domain.user.dto.ShowUserDTO;
import br.com.fiap.airquality.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/air_quality")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public List<ShowUserDTO> findAll(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public ShowUserDTO findById(@PathVariable UUID id){
        return userService.findById(id);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        userService.delete(id);
    }

    @PutMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public ShowUserDTO update(@RequestBody User user){
        return userService.update(user);
    }

}