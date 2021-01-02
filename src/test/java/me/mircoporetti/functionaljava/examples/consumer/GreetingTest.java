package me.mircoporetti.functionaljava.examples.consumer;

import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingTest {

    @Test
    void greetPerson() throws Exception {
        Person person = new Person("Mirco", "+39 3401234567");

        String greeting = tapSystemOut(() -> Greeting.greet.accept(person));

        assertEquals("Hello Mirco, phone number: +39 3401234567", greeting.trim());

    }

    @Test
    void greetPersonWithMaskedPhoneNumber() throws Exception {
        Person person = new Person("Mirco", "+39 3401234567");

        String greeting = tapSystemOut(() -> Greeting.greetShowingPhoneNumber.accept(person, false));

        assertEquals("Hello Mirco, phone number: ***********567", greeting.trim());

    }
}