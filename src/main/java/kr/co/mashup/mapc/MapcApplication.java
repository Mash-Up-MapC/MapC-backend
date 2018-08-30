package kr.co.mashup.mapc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.ZoneOffset;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackages = "kr.co.mashup.mapc", basePackageClasses = Jsr310Converters.class)
@EnableJpaRepositories(basePackages = "kr.co.mashup.mapc")
@EnableJpaAuditing
public class MapcApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneOffset.UTC));
        SpringApplication.run(MapcApplication.class, args);
    }
}
