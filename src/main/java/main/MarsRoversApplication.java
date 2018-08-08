package main;

import interaction.ProcessSteps;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by routarddev on 7/08/18.
 */
@SpringBootApplication
public class MarsRoversApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(MarsRoversApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
            new ProcessSteps().run(args);
        } else { //By default, use file positions and instructions
            new ProcessSteps().run("1");
        }
    }
}
