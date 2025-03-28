package br.com.storygem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.storygem.model.User;

public interface UserRepository extends JpaRepository <User,Long>{

    
};
