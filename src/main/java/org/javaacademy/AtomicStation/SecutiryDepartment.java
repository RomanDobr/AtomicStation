package org.javaacademy.AtomicStation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class SecutiryDepartment {
    private int accidentCountPeriod;
    private NuclearStation nuclearStation;

    @Autowired
    @Lazy
    public SecutiryDepartment(NuclearStation nuclearStation) {
        this.nuclearStation = nuclearStation;
    }

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
