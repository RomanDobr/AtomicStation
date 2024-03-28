package org.javaacademy.AtomicStation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
@Profile("morocco")
public class MoroccoEconomicDepartment extends EconomicDepartment {
    private static final long RATE = 1_000_000_000L;

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        double total = 0.0;
        if (countElectricity <= RATE * 5) {
            total += countElectricity * this.getCena();
        } else if (countElectricity > RATE * 5) {
            total +=  (RATE * 5 * this.getCena()) + ((countElectricity - (RATE * 5)) * (this.getCena() + 1));
        }
        return new BigDecimal(total);
    }
}
