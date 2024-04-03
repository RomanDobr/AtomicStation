package org.javaacademy.AtomicStation;

import lombok.extern.slf4j.Slf4j;
import org.javaacademy.AtomicStation.department.FranceEconomicDepartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
@Slf4j
@SpringBootTest
@ActiveProfiles("france")
public class FranceEconomicDepartmentTest {
    @Autowired
    private FranceEconomicDepartment franceEconomicDepartment;

    @Test
    void incomeSuccess() {
        Assertions.assertEquals(BigDecimal.valueOf(1785842690).setScale(2),
                franceEconomicDepartment.computeYearIncomes(3620000000L));
        log.info(franceEconomicDepartment.toString());
    }

    @Test
    void notFaultSuccess() {
        Assertions.assertDoesNotThrow(() -> franceEconomicDepartment.computeYearIncomes(3620000000L));
    }

}
