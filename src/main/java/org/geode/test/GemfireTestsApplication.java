package org.geode.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class GemfireTestsApplication implements CommandLineRunner {

    @Autowired
    GemfireTestsConfiguration gemfireTestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(GemfireTestsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Scenario test = new Scenario();

        test.startGemfireServer(gemfireTestConfiguration.getHostname(), gemfireTestConfiguration.getPort());
        test.fillRegions();

    }

}
