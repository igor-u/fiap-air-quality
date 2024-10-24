package br.com.fiap.airquality.controller.user;

import br.com.fiap.airquality.model.user.dto.LoginDTO;
import br.com.fiap.airquality.model.user.dto.ShowUserDTO;
import br.com.fiap.airquality.model.user.dto.SignUpUserDTO;
import br.com.fiap.airquality.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<ShowUserDTO> login(@RequestBody @Valid LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.email(),
                        loginDTO.password()
                );

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ShowUserDTO register(@RequestBody @Valid SignUpUserDTO signUpUserDTO) {
        ShowUserDTO signedUpUser = null;
        signedUpUser = userService.createUser(signUpUserDTO);

        return  signedUpUser;
    }

}
