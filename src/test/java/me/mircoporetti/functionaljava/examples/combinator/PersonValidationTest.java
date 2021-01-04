package me.mircoporetti.functionaljava.examples.combinator;

import org.junit.jupiter.api.Test;

import static me.mircoporetti.functionaljava.examples.combinator.PersonValidator.PersonValidationResult.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonValidationTest {

    @Test
    void nameIsValid() {
        Person toBeValidated = new Person("Mirco", "anEmail", "aPhoneNumber");
        assertEquals(SUCCESS, PersonValidator.isNameValid().apply(toBeValidated));
    }

    @Test
    void nameIsNotValid() {
        Person toBeValidated = new Person("", "anEmail", "aPhoneNumber");
        assertEquals(NOT_VALID_NAME, PersonValidator.isNameValid().apply(toBeValidated));
    }

    @Test
    void combineValidations() {
        Person toBeValidated = new Person("Mirco", "email@something.com", "01 00112233");

        PersonValidator.PersonValidationResult result =
                PersonValidator.isNameValid()
                        .and(PersonValidator.isMailValid())
                        .and(PersonValidator.isPhoneValid())
                        .apply(toBeValidated);

        assertEquals(SUCCESS, result);
    }

    @Test
    void failCauseOneFails() {
        Person toBeValidated = new Person("Mirco", "wrongEmail", "01 00112233");

        PersonValidator.PersonValidationResult result =
                PersonValidator.isNameValid()
                        .and(PersonValidator.isMailValid())
                        .and(PersonValidator.isPhoneValid())
                        .apply(toBeValidated);

        assertEquals(NOT_VALID_EMAIL, result);
    }
}
