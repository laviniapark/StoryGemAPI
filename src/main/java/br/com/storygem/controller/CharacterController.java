package br.com.storygem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.storygem.model.Character;
import br.com.storygem.repository.CharacterRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/creations")
public class CharacterController {
    
    @Autowired
    private CharacterRepository repository;

    @GetMapping
    public List<Character> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Character> create(@RequestBody Character character) {

        repository.save(character);
        return ResponseEntity.status(201).body(character);
    }
    
    @PutMapping
    public ResponseEntity<Character> edit(@RequestBody Character character) {
        Character existC = getCharacter(character.getId());
        
        existC.setName(character.getName());
        existC.setAge(character.getAge());
        existC.setDescription(character.getDescription());
        existC.setPowers(character.getPowers());
        existC.setImgUrl(character.getImgUrl());

        repository.save(existC);

        return ResponseEntity.ok().body(existC);
    }

    @DeleteMapping
    public void delete(@RequestBody Character character) {  
        Character existingCharacter = getCharacter(character.getId());
        if (existingCharacter != null) {
            repository.delete(existingCharacter);
        }
    }

    private Character getCharacter(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personagem não encontrado"));
    }

}
