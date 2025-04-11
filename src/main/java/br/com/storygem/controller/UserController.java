package br.com.storygem.controller;

import br.com.storygem.dto.LoginDTO;
import br.com.storygem.dto.RegisterDTO;
import br.com.storygem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
private UserService userService;

@PostMapping("/register")
public ResponseEntity<String> register(@Valid @RequestBody RegisterDTO dto) {
    return ResponseEntity.ok(userService.register(dto));
}

@PostMapping("/login")
public ResponseEntity<String> login(@Valid @RequestBody LoginDTO dto) {
    return ResponseEntity.ok(userService.login(dto));
}

}
