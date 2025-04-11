package br.com.storygem.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.storygem.model.Character;
import br.com.storygem.repository.CharacterRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DatabaseSeeder {
    
    @Autowired
    private CharacterRepository characterRepo;

    @PostConstruct
    public void init() {
        characterRepo.saveAll(
            List.of(
                Character.builder().name("João Carlos").age("??").description("Brincalhão e extrovertido").powers("Ser engraçado").build(),
                Character.builder().name("Giovanna Laturague").age("19").description("Gente fina e ama bater um papo").powers("Excelente em jogos").build(),
                Character.builder().name("Lavinia Park").age("21").description("Complicada de lidar, porém ama um rolê insalubre").powers("Sabe dançar macarena de cor").build()
            )
        );
    }
}
