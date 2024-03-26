package org.javaacademy.AtomicStation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class NuclearConfig {
    @Bean
    public FranceEconomicDepartment economicDepartment() {
        return new FranceEconomicDepartment();
    }
}
