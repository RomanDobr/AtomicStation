package org.javaacademy.AtomicStation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("france")
public class FranceEconomicDepartment extends EconomicDepartment {



//    public FranceEconomicDepartment(String currency, double cena) {
//        this.currency = currency;
//        this.cena = cena;
//    }

    @Override
    BigDecimal computeYearIncomes(long countElectricity) {
        return new BigDecimal(1);
    }

}
