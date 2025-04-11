package br.com.storygem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info = @Info(title = "Story Gem", version = "v1", description = "Projeto WEB de criação de fichas"))
public class StorygemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorygemApplication.class, args);
	}

}
