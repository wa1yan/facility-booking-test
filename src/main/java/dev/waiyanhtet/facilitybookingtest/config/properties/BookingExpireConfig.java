package dev.waiyanhtet.facilitybookingtest.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "booking-expire")
@NoArgsConstructor
@AllArgsConstructor
public class BookingExpireConfig {

    private int hour;
    private long fixedRateInMs;
}
