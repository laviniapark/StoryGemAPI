package br.com.storygem.service;

import br.com.storygem.dto.LoginDTO;
import br.com.storygem.dto.RegisterDTO;
import br.com.storygem.model.User;
import br.com.storygem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(RegisterDTO dto) {
        if (userRepository.findByEmail(dto.email()).isPresent()) {
            throw new RuntimeException("Usuário já registrado com esse email");
        }

        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        userRepository.save(user);

        return "Usuário registrado com sucesso!";
    }

    public String login(LoginDTO dto) {
        User user = userRepository.findByEmail(dto.email())
            .orElseThrow(() -> new RuntimeException("Email inválido"));

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new RuntimeException("Senha incorreta");
        }

        return "Login bem-sucedido!";
    }
}
