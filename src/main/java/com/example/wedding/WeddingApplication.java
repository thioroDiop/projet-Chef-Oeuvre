package com.example.wedding;

import com.example.wedding.models.AppUsers;
import com.example.wedding.models.Roles;
import com.example.wedding.repositories.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableSwagger2
@SpringBootApplication
public class WeddingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeddingApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        return (args) -> {
            AppUsers admin = appUserRepository.save(new AppUsers("admin", passwordEncoder.encode("admin"), List.of(Roles.ROLE_ADMIN)));
            AppUsers guest = appUserRepository.save(new AppUsers("guest", passwordEncoder.encode("guest"), List.of(Roles.ROLE_GUEST)));
            };
    }


}
