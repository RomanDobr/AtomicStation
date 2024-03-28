package org.javaacademy.AtomicStation;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import java.math.BigDecimal;
@Getter
public abstract class EconomicDepartment {
    @Value("${country.name}")
    private String country;
    @Value("${currency.name}")
    private String currency;
    @Value("${currency.value}")
    private double cena;

    abstract BigDecimal computeYearIncomes(long countElectricity);
}
