package me.mircoporetti.functionaljava.examples.callback;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonInformationTest {

    @Test
    void greetWithAName() {
        assertEquals("Hi Mirco!", PersonInformation.requestGreetFor.apply("Mirco"));
    }

    @Test
    void greetWithoutAName() {
        assertEquals("Hi, is your name a secret?", PersonInformation.requestGreetFor.apply(""));
    }
}