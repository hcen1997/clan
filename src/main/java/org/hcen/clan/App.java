package org.hcen.clan;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
        info();
    }

    private static void info() {
        log.info("hello world");
        log.info("this is about to build a clan");
        log.info("but if i can build one, why not the whole world" +
                " full of clan?");

        log.info("so, i will build a clan first, and a world second");
        log.info(" the ");
    }

}
