package kr.co.mashup.mapc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZoneOffset;
import java.util.TimeZone;

@SpringBootApplication
public class MapcApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneOffset.UTC));
        SpringApplication.run(MapcApplication.class, args);
    }
}
