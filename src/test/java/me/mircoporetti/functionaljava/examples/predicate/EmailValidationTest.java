package me.mircoporetti.functionaljava.examples.predicate;

import org.junit.jupiter.api.Test;

import static me.mircoporetti.functionaljava.examples.predicate.EmailValidation.*;
import static org.junit.jupiter.api.Assertions.*;

class EmailValidationTest {

    @Test
    void validate() {
        assertTrue(validate.test("aMail@goofy.it"));
    }

    @Test
    void checkIsDotCom() {
        assertTrue(checkIsDotCom.test("something.com"));
    }

    @Test
    void validateAndCheckIsDotCom() {
        assertTrue(validate.and(checkIsDotCom).test("aMail@goofy.com"));
    }

    @Test
    void checkIsValidateOrDotCom() {
        assertTrue(validate.or(checkIsDotCom).test("aMail@goofy.it"));
        assertTrue(validate.or(checkIsDotCom).test("aMail.com"));
    }

    @Test
    void twoAddresses_haveSameDomain() {
        assertTrue(checkSameDomain.test("aMail@goofy.it", "anotherMail@goofy.it"));
    }
}