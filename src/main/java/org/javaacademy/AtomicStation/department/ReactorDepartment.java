package org.javaacademy.AtomicStation.department;

import org.javaacademy.AtomicStation.nuclearexception.NuclearFuelIsEmptyException;
import org.javaacademy.AtomicStation.nuclearexception.ReactorWorkException;
import org.springframework.stereotype.Component;

@Component
public class ReactorDepartment {
    private boolean isWork = false;
    private int countStart;
    private static final long COUNT_ENERGY = 10_000_000L;

    public long run() throws ReactorWorkException, NuclearFuelIsEmptyException {
        if (isWork) {
            throw new ReactorWorkException("Реактор уже работает");
        }
        setWork(true);
        countStart++;
        if (countStart % 100 == 0) {
            throw new NuclearFuelIsEmptyException();
        }
        return COUNT_ENERGY;
    }

    public void stop() throws ReactorWorkException {
        if (!isWork) {
            throw new ReactorWorkException("Реактор уже выключен");
        }
        setWork(false);
    }

    public boolean isWork() {
        return isWork;
    }

    public void setWork(boolean work) {
        isWork = work;
    }

    public void setCountStart(int countStart) {
        this.countStart = countStart;
    }
}
