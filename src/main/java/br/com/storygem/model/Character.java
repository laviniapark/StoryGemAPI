package br.com.storygem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Character {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String age;
    private String description;
    private String powers;
    private String imgUrl;

    public Character (String name, String age, String description, String powers, String imgUrl) {
        this.name = name;
        this.age = age;
        this.description = description;
        this.powers = powers;
        this.imgUrl = imgUrl;
    }
}
