package com.maciej.privateMethods.interfaces;

public interface InterfaceWithPrivateMethods {

//    Private methods in interface were introduced for better code reuse.

//    In Java 9 and later versions, an interface can have six kinds of things:
//    Constant variables
//    Abstract methods
//    Default methods
//    Static methods
//    Private methods
//    Private Static methods

    default int returnOne() {
        return getNumber();
    }

    static String returnA() {
        return getLetter();
    }

    private int getNumber() {
        return 1;
    }

    private static String getLetter() {
        return "A";
    }
}
