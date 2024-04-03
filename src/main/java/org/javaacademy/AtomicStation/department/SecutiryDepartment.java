package org.javaacademy.AtomicStation.department;

import org.javaacademy.AtomicStation.station.NuclearStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class SecutiryDepartment {
    private int accidentCountPeriod;
    @Lazy
    @Autowired
    private NuclearStation nuclearStation;

    public void addAccident() {
        accidentCountPeriod++;
    }

    public int getCountAccidents() {
        return accidentCountPeriod;
    }

    public void reset() {
        nuclearStation.incrementAccident(getCountAccidents());
        accidentCountPeriod = 0;
    }
}
