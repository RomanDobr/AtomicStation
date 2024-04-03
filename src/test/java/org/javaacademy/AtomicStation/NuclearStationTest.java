package org.javaacademy.AtomicStation;

import org.javaacademy.AtomicStation.nuclearexception.ReactorWorkException;
import org.javaacademy.AtomicStation.station.NuclearStation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NuclearStationTest {
    @Autowired
    private NuclearStation nuclearStation;

    @BeforeEach
    void init() {
        nuclearStation.setTotalResult(0L);
    }

    @Test
    void startYearSuccess() {
        Assertions.assertEquals(3620000000L, nuclearStation.startYear());
    }

    @Test
    void notFaultSuccess() {
        Assertions.assertDoesNotThrow(() -> nuclearStation.startYear());
    }

    @Test
    void startSuccess() {
        Assertions.assertDoesNotThrow(() -> nuclearStation.start(1));
    }

}
