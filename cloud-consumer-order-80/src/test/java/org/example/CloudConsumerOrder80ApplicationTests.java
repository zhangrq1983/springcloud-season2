package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.ZonedDateTime;

@SpringBootTest
class CloudConsumerOrder80ApplicationTests {

    @Test
    void contextLoads() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime = " + zonedDateTime);
    }

}
