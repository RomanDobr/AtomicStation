package org.javaacademy.AtomicStation;

import org.javaacademy.AtomicStation.nuclearexception.NuclearFuelIsEmptyException;
import org.javaacademy.AtomicStation.nuclearexception.ReactorWorkException;
import org.springframework.stereotype.Component;
import java.util.stream.IntStream;


@Component
public class NuclearStation {
    private ReactorDepartment reactorDepartment;
    private double totalResult;

    public NuclearStation(ReactorDepartment reactorDepartment) {
        this.reactorDepartment = reactorDepartment;
    }

    private void startYear() {
        System.out.println("Атомная станция начала работу");
        IntStream.range(0, 365).forEach(i -> totalResult += helperStartYear());
        reactorDepartment.setCountStart(0);
        System.out.printf("Атомная станция закончила работу. За год Выработано %s киловатт/часов", totalResult);
    }

    private double helperStartYear() {
        double valueYear = 0;
        try {
            valueYear += reactorDepartment.run();
            reactorDepartment.stop();
        } catch (ReactorWorkException | NuclearFuelIsEmptyException e) {
            reactorDepartment.setWork(false);
            System.out.println(e.getMessage());
            System.out.println("Внимание! Происходят работы на атомной станции! Электричества нет!");
        }
        return valueYear;
    }

    public void start(int year) {
        IntStream.range(0, year).forEach(i -> startYear());
    }
}
