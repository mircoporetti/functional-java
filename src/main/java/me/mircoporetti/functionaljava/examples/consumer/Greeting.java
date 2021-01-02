package me.mircoporetti.functionaljava.examples.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Greeting {

    static Consumer<Person> greet = person ->
            System.out.println("Hello " + person.getName() + ", phone number: " + person.getPhoneNumber());

    static BiConsumer<Person, Boolean> greetShowingPhoneNumber = (person, showPhoneNumber) ->
    {
        String phoneNumber = person.getPhoneNumber();
        System.out.println(
                "Hello " + person.getName() + ", phone number: " +
                        (showPhoneNumber
                                ? phoneNumber
                                : "*".repeat(phoneNumber.length() - 3) + phoneNumber.substring(phoneNumber.length() - 3))
        );
    };

}
