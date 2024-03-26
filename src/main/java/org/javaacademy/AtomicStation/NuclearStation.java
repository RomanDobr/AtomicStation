package org.javaacademy.AtomicStation;

import lombok.extern.slf4j.Slf4j;
import org.javaacademy.AtomicStation.nuclearexception.NuclearFuelIsEmptyException;
import org.javaacademy.AtomicStation.nuclearexception.ReactorWorkException;
import org.springframework.stereotype.Component;
import java.util.stream.IntStream;
@Slf4j
@Component
public class NuclearStation {

    private ReactorDepartment reactorDepartment;
    private SecutiryDepartment secutiryDepartment;
    private FranceEconomicDepartment franceEconomicDepartment;
    private long totalResult;
    private int accidentCountAllTime;

    public NuclearStation(ReactorDepartment reactorDepartment,
                          SecutiryDepartment secutiryDepartment,
                          FranceEconomicDepartment franceEconomicDepartment) {
        this.reactorDepartment = reactorDepartment;
        this.secutiryDepartment = secutiryDepartment;
        this.franceEconomicDepartment = franceEconomicDepartment;
    }

    private void startYear() {
        log.info("Атомная станция начала работу");
        IntStream.range(0, 365).forEach(i -> totalResult += helperStartYear());
        reactorDepartment.setCountStart(0);
        log.info("Атомная станция закончила работу. За год Выработано {} киловатт/часов\n", totalResult);
        log.warn("Количество инцидентов за год: " + secutiryDepartment.getCountAccidents());
        secutiryDepartment.reset();
    }

    private long helperStartYear() {
        long valueYear = 0;
        try {
            valueYear += reactorDepartment.run();
            reactorDepartment.stop();
        } catch (ReactorWorkException | NuclearFuelIsEmptyException e) {
            reactorDepartment.setWork(false);
            secutiryDepartment.addAccident();
            log.error(e.getMessage());
            log.warn("Внимание! Происходят работы на атомной станции! Электричества нет!");
        }
        return valueYear;
    }

    public void start(int year) {
        IntStream.range(0, year).forEach(i -> startYear());
        log.warn("Количество инцидентов за всю работу станции: " + this.getAccidentCountAllTime());
    }

    public void incrementAccident (int count) {
        accidentCountAllTime += count;
    }

    public int getAccidentCountAllTime() {
        return accidentCountAllTime;
    }

    public long getTotalResult() {
        return totalResult;
    }
}
