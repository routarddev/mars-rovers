package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by hadrien on 7/08/18.
 */
@SpringBootApplication
@ComponentScan(basePackages = {""})
//@PropertySources({ @PropertySource("classpath:application.properties") })
public class MarsRoversApplication {

    public static void main(String[] args) {

        SpringApplication.run(MarsRoversApplication.class, args);
    }
}
