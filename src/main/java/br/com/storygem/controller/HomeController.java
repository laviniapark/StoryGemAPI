package br.com.storygem.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.storygem.model.Character;

import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HomeController {
    
    @GetMapping("/home")
    public ResponseEntity<?> getAll() {

        Character c1 = new Character("João Carlos", "??", "Brincalhão e extrovertido", "Ser engraçado", null);
        Character c2 = new Character("Giovanna Laturague", "19", "Gente fina e ama bater um papo", "Excelente em jogos", null);
        Character c3 = new Character("Lavinia Park", "21", "Complicada de lidar, porém ama um rolezinho insalubre", "Sabe dançar macarena de cor", null);

        return ResponseEntity.ok().body(Arrays.asList(c1, c2, c3));
    }
    
}
