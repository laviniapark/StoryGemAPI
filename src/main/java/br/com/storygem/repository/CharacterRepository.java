package br.com.storygem.repository;

import br.com.storygem.model.Character;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long>{
    
}
