package br.com.storygem.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.storygem.model.Character;
import io.swagger.v3.oas.annotations.Operation;

import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "*")
public class HomeController {
    
    @GetMapping
    @Operation(tags = "Home", summary = "Pega as informações padrão dos cards da Home" )
    public ResponseEntity<?> getAll() {

        Character c1 = new Character(1L,"João Carlos", "??", "Brincalhão e extrovertido", "Ser engraçado", null);
        Character c2 = new Character(2L,"Giovanna Laturague", "19", "Gente fina e ama bater um papo", "Excelente em jogos", null);
        Character c3 = new Character(3L,"Lavinia Park", "21", "Complicada de lidar, porém ama um rolezinho insalubre", "Sabe dançar macarena de cor", null);

        return ResponseEntity.ok().body(Arrays.asList(c1, c2, c3));
    }
    
}
