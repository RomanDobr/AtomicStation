package org.javaacademy.AtomicStation.department;

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
    private double price;

    public abstract BigDecimal computeYearIncomes(long countElectricity);

    @Override
    public String toString() {
        return "EconomicDepartment{" +
                "country='" + country + '\'' +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                '}';
    }
}
