package org.javaacademy.AtomicStation;

import org.javaacademy.AtomicStation.department.ReactorDepartment;
import org.javaacademy.AtomicStation.nuclearexception.NuclearFuelIsEmptyException;
import org.javaacademy.AtomicStation.nuclearexception.ReactorWorkException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReactorDepartmentTest {
    @Autowired
    private ReactorDepartment reactorDepartment;

    @Test
    void reactorWorkExceptionSuccess() {
        reactorDepartment.setWork(true);
        Assertions.assertThrows(ReactorWorkException.class, () -> reactorDepartment.run());
    }

    @Test
    void nuclearFuelIsEmptyExceptionSuccess() {
        reactorDepartment.setWork(false);
        reactorDepartment.setCountStart(99);
        Assertions.assertThrows(NuclearFuelIsEmptyException.class, () -> reactorDepartment.run());
    }

    @Test
    void notFaultSuccess() throws NuclearFuelIsEmptyException, ReactorWorkException {
        reactorDepartment.setWork(false);
        reactorDepartment.setCountStart(1);
        Assertions.assertDoesNotThrow(() -> reactorDepartment.run());
    }

    @Test
    void runSuccess() throws NuclearFuelIsEmptyException, ReactorWorkException {
        reactorDepartment.setWork(false);
        reactorDepartment.setCountStart(1);
        Assertions.assertDoesNotThrow(() -> reactorDepartment.run());
    }

    @Test
    void countEnergySuccess() throws NuclearFuelIsEmptyException, ReactorWorkException {
        reactorDepartment.setWork(false);
        reactorDepartment.setCountStart(1);
        Assertions.assertEquals(10_000_000L, reactorDepartment.run());
    }
}
