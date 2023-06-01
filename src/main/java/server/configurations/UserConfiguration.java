package server.configurations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import server.common.UserModel;
import server.common.UserRoleEnum;
import server.repositories.UserRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfiguration {

    @Bean
    @Order(2)
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            UserModel krasi = new UserModel(
                    "Krasimir",
                    "krasi@flightmail.com",
                    "abc",
                    LocalDate.of(2002, Month.JANUARY, 14),
                    UserRoleEnum.SERVICE
            );
            UserModel lena = new UserModel(
                    "Lena",
                    "lena@aeronautica.com",
                    "secure_password",
                    LocalDate.of(2003, Month.JULY, 10),
                    UserRoleEnum.SERVICE
            );
            repository.saveAll(
                    List.of(krasi, lena)
            );
        };
    }
}
