package br.com.storygem.repository;

import br.com.storygem.model.Character;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.JpaRepository;

@EnableCaching
public interface CharacterRepository extends JpaRepository<Character, Long>{
    
}
