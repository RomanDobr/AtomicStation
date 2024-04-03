package org.javaacademy.AtomicStation;

import lombok.extern.slf4j.Slf4j;
import org.javaacademy.AtomicStation.department.MoroccoEconomicDepartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@Slf4j
@SpringBootTest
@ActiveProfiles("morocco")
public class MoroccoEconomicDepartmentTest {
    @Autowired
    private MoroccoEconomicDepartment moroccoEconomicDepartment;

    @Test
    void incomeSuccess() {
        Assertions.assertEquals(BigDecimal.valueOf(18100000000L),
                moroccoEconomicDepartment.computeYearIncomes(3620000000L));
        log.info(moroccoEconomicDepartment.toString());
    }

    @Test
    void notFaultSuccess() {
        Assertions.assertDoesNotThrow(() -> moroccoEconomicDepartment.computeYearIncomes(3620000000L));
    }

}
