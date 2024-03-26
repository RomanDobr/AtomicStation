package org.javaacademy.AtomicStation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public abstract class EconomicDepartment {

    @Value("${currency.name}")
    private String currency;
    @Value("${currency.value}")
    private double cena;

    abstract BigDecimal computeYearIncomes(long countElectricity);

    @Override
    public String toString() {
        return "EconomicDepartment{" +
                "currency='" + currency + '\'' +
                ", cena=" + cena +
                '}';
    }
}
