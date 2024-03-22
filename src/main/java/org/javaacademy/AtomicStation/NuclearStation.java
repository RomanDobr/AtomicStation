package org.javaacademy.AtomicStation;

import org.javaacademy.AtomicStation.nuclearexception.NuclearFuelIsEmptyException;
import org.javaacademy.AtomicStation.nuclearexception.ReactorWorkException;
import org.springframework.stereotype.Component;
import java.util.stream.IntStream;

@Component
public class NuclearStation {
    private ReactorDepartment reactorDepartment;
    private SecutiryDepartment secutiryDepartment;
    private long totalResult;
    private int accidentCountAllTime;

    public NuclearStation(ReactorDepartment reactorDepartment, SecutiryDepartment secutiryDepartment) {
        this.reactorDepartment = reactorDepartment;
        this.secutiryDepartment = secutiryDepartment;
    }

    private void startYear() {
        System.out.println("Атомная станция начала работу");
        IntStream.range(0, 365).forEach(i -> totalResult += helperStartYear());
        reactorDepartment.setCountStart(0);
        System.out.printf("Атомная станция закончила работу. За год Выработано %s киловатт/часов\n", totalResult);
        System.out.println("Количество инцидентов за год: " + secutiryDepartment.getCountAccidents());
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
            System.out.println(e.getMessage());
            System.out.println("Внимание! Происходят работы на атомной станции! Электричества нет!");
        }
        return valueYear;
    }

    public void start(int year) {
        IntStream.range(0, year).forEach(i -> startYear());
        System.out.println("Количество инцидентов за всю работу станции: " + this.getAccidentCountAllTime());
    }

    public void incrementAccident (int count) {
        accidentCountAllTime += count;
    }

    public int getAccidentCountAllTime() {
        return accidentCountAllTime;
    }
}
