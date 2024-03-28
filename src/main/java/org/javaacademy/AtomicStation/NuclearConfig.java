package org.javaacademy.AtomicStation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class NuclearConfig {

    @Bean
    @Profile("france")
    public FranceEconomicDepartment franceEconomicDepartment() {
        return new FranceEconomicDepartment();
    }

    @Bean
    @Profile("morocco")
    public MoroccoEconomicDepartment moroccoEconomicDepartment() {
        return new MoroccoEconomicDepartment();
    }


}
