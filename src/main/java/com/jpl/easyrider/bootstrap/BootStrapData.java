package com.jpl.easyrider.bootstrap;

import com.jpl.easyrider.domain.Horse;
import com.jpl.easyrider.domain.Role;
import com.jpl.easyrider.domain.Training;
import com.jpl.easyrider.domain.User;
import com.jpl.easyrider.repositories.HorseRepository;
import com.jpl.easyrider.repositories.RoleRepository;
import com.jpl.easyrider.repositories.TrainingRepository;
import com.jpl.easyrider.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;

//@Component
@Profile("dev")
public class BootStrapData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TrainingRepository trainingRepository;
    private final HorseRepository horseRepository;
//    private PasswordEncoder passwordEncoder;

    @Autowired
    public BootStrapData(UserRepository userRepository, RoleRepository roleRepository, TrainingRepository trainingRepository, HorseRepository horseRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.trainingRepository = trainingRepository;
        this.horseRepository = horseRepository;
 //       this.passwordEncoder = passwordEncoder;
    }

//    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {

        Role role1 = new Role();
        role1.setName("ROLE_MANAGER");
        roleRepository.save(role1);

        Role role2 = new Role();
        role2.setName("ROLE_INSTRUCTOR");
        roleRepository.save(role2);

        Role role3 = new Role();
        role3.setName("ROLE_RIDER");
        roleRepository.save(role3);

        Horse horse1 = new Horse();
        horse1.setAge(10);
        horse1.setName("Plotka");
        horseRepository.save(horse1);

        Horse horse2 = new Horse();
        horse2.setAge(6);
        horse2.setName("Rakieta");
        horseRepository.save(horse2);

        Horse horse3 = new Horse();
        horse3.setAge(16);
        horse3.setName("Zajac");
        horseRepository.save(horse3);

        Training training1 = new Training();
        training1.setDateTraining(Date.from(Instant.now()));
        training1.setHorse(horse3);


        User u1 = new User();
        u1.setFirstName("Adam");
        u1.setLastName("Nowak");
        u1.setEmail("mailu1@mail.pl");
        u1.setPassword(passwordEncoder().encode("haslo1"));
        u1.setWeight(80);
        u1.setEnabled(true);
        u1.setTokenExpired(false);
        u1.setRoles(List.of(role1));
        training1.setUser(u1);
   //     u1.setTrainings(List.of(training1));
        userRepository.save(u1);

        trainingRepository.save(training1);

        User u2 = new User();
        u2.setFirstName("Basia");
        u2.setLastName("Zalewska");
        u2.setEmail("mailu2@mail.pl");
        u2.setPassword(passwordEncoder().encode("haslo1"));
        u2.setWeight(60);
        u2.setEnabled(true);
        u2.setTokenExpired(false);
        u2.setRoles(List.of(role2));

        userRepository.save(u2);

        User u3 = new User();
        u3.setFirstName("Edward");
        u3.setLastName("Bocian");
        u3.setEmail("dingo5017@gmail.com");
        u3.setPassword(passwordEncoder().encode("haslo1"));
        u3.setWeight(90);
        u3.setEnabled(true);
        u3.setTokenExpired(false);
        u3.setRoles(List.of(role3));

        userRepository.save(u3);

        System.out.println("Users:" + userRepository.count());
    }
}
