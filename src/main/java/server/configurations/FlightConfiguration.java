package server.configurations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import server.common.FlightModel;
import server.common.FlightStatusEnum;
import server.repositories.FlightRepository;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Configuration
public class FlightConfiguration {

    @Bean
    @Order(2)
    CommandLineRunner flightCommandLineRunner(FlightRepository repository) {
        return args -> {
            FlightModel flight1 = new FlightModel(
                    "Sofia",
                    "Munich",
                    LocalDateTime.of(2022, Month.JUNE, 19, 10, 30),
                    LocalDateTime.of(2022, Month.JUNE, 19, 12, 30),
                    "Terminal 2",
                    "Airbus A320",
                    "Lufthansa",
                    FlightStatusEnum.NORMAL

            );
            FlightModel flight2 = new FlightModel(
                    "Sofia",
                    "Vienna",
                    LocalDateTime.of(2022, Month.JUNE, 19, 15, 45),
                    LocalDateTime.of(2022, Month.JUNE, 19, 17, 15),
                    "Terminal 2",
                    "Boeing 737",
                    "Wizz Air",
                    FlightStatusEnum.NORMAL
            );
            FlightModel flight3 = new FlightModel(
                    "Munich",
                    "Wessling",
                    LocalDateTime.of(2022, Month.AUGUST, 14, 15, 45),
                    LocalDateTime.of(2022, Month.AUGUST, 14, 17, 15),
                    "Terminal 2",
                    "Boeing 747",
                    "Ryan Air",
                    FlightStatusEnum.DELAYED
            );
            FlightModel flight4 = new FlightModel(
                    "Kourou",
                    "Mars",
                    LocalDateTime.of(2024, Month.AUGUST, 14, 15, 45),
                    LocalDateTime.of(2026, Month.AUGUST, 13, 10, 15),
                    "Terminal 1",
                    "Falcon 69",
                    "SpaceX",
                    FlightStatusEnum.DELAYED
            );
            FlightModel flight5 = new FlightModel(
                    "Kourou",
                    "Mars",
                    LocalDateTime.of(2024, Month.AUGUST, 14, 15, 45),
                    LocalDateTime.of(2026, Month.AUGUST, 13, 10, 15),
                    "Terminal 1",
                    "Falcon 69",
                    "SpaceX",
                    FlightStatusEnum.CANCELED
            );
            repository.saveAll(
                    List.of(flight1, flight2,flight3,flight4,flight5)
            );
        };
    }
}
