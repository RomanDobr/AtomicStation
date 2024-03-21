package org.javaacademy.AtomicStation;

import org.javaacademy.AtomicStation.nuclearexception.NuclearFuelIsEmptyException;
import org.javaacademy.AtomicStation.nuclearexception.ReactorWorkException;
import org.springframework.stereotype.Component;

@Component
public class ReactorDepartment {
    private boolean isWork = false;
    private int countStart;
    public static final int COUNT_ENERGY = 10_000_000;

    protected int run() throws ReactorWorkException, NuclearFuelIsEmptyException {
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

    protected void stop() throws ReactorWorkException {
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
