package org.javaacademy.AtomicStation;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.AtomicStation.nuclearexception.NuclearFuelIsEmptyException;
import org.javaacademy.AtomicStation.nuclearexception.ReactorWorkException;
import org.springframework.stereotype.Component;
import java.util.stream.IntStream;
@Slf4j
@Component
@RequiredArgsConstructor
public class NuclearStation {
    @NonNull
    private ReactorDepartment reactorDepartment;
    @NonNull
    private SecutiryDepartment secutiryDepartment;
    @NonNull
    private EconomicDepartment economicDepartment;
    private long totalResult;
    private int accidentCountAllTime;


    private void startYear() {
        log.info("Атомная станция начала работу");
        IntStream.range(0, 365).forEach(i -> totalResult += helperStartYear());
        reactorDepartment.setCountStart(0);
        log.info("Атомная станция закончила работу. За год Выработано {} киловатт/часов", totalResult);
        log.warn("Количество инцидентов за год: " + secutiryDepartment.getCountAccidents());
        log.info("Доход за год составил {} {}\n",
                economicDepartment.computeYearIncomes(totalResult),
                economicDepartment.getCurrency());
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
        log.info("\n");
        log.info("Действие происходит в стране: {} \n", economicDepartment.getCountry());
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
