package org.javaacademy.AtomicStation.nuclearexception;

public class NuclearFuelIsEmptyException extends Throwable {
    public NuclearFuelIsEmptyException() {
        super("атомный реактор истощен");
    }
}
