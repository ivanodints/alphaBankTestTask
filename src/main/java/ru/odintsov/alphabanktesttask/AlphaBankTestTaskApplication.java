package ru.odintsov.alphabanktesttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlphaBankTestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlphaBankTestTaskApplication.class, args);
    }

}
