package org.javaacademy.AtomicStation.department;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@Profile("france")
public class FranceEconomicDepartment extends EconomicDepartment {
    private static final long RATE = 1_000_000_000L;

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        long value = countElectricity / RATE;
        long remainder = countElectricity - (value * RATE);
        double total = 0.0;
        for (long i = 0; i < value; i++) {
            total += RATE * this.getPrice() * Math.pow(0.99, i);
        }
        total += remainder * this.getPrice() * Math.pow(0.99, value);
        return  new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
    }
}
