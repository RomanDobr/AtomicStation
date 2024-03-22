package org.javaacademy.AtomicStation.nuclearexception;

public class NuclearFuelIsEmptyException extends Exception {
    public NuclearFuelIsEmptyException() {
        super("атомный реактор истощен");
    }
}
