package me.mircoporetti.functionaljava.examples.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private List<Person> people;

    @BeforeEach
    void setUp() {
        people = Arrays.asList(
                new Person("Mirco", Gender.MALE),
                new Person("Jessica", Gender.MALE),
                new Person("Laura", Gender.FEMALE),
                new Person("Valeria", Gender.FEMALE)
        );
    }

    @Test
    void allGenders() {
        Set<Gender> expected = Set.of(Gender.MALE,Gender.FEMALE);

        Set<Gender> result = people.stream().map(person -> person.gender).collect(Collectors.toSet());

        assertEquals(expected, result);
    }

    @Test
    void allPeopleNamesLength() {
        List<Integer> expected = List.of(5,7,5,7);

        List<Integer> result =
                people.stream()
                        .map(person -> person.name)
                        .map(String::length).collect(Collectors.toList());

        assertEquals(expected, result);
    }

    @Test
    void allFemalePeopleNames() {
        List<String> expected = List.of("Laura","Valeria");

        List<String> result =
                people.stream()
                        .filter(person -> person.gender.equals(Gender.FEMALE))
                        .map(person -> person.name)
                .collect(Collectors.toList());

        assertEquals(expected, result);
    }

    @Test
    void checkAreAllFemale() {

        boolean allFemale = people.stream().allMatch(person -> person.gender.equals(Gender.FEMALE));
        assertFalse(allFemale);
    }

    @Test
    void checkAtLeastAFemale() {

        boolean anyFemale = people.stream().anyMatch(person -> person.gender.equals(Gender.FEMALE));
        assertTrue(anyFemale);
    }

    @Test
    void checkNoUnknown() {

        boolean anyFemale = people.stream().noneMatch(person -> person.gender.equals(Gender.UNKNOWN));
        assertTrue(anyFemale);
    }

    private static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    private enum Gender {
        MALE,
        FEMALE,
        UNKNOWN
    }
}


