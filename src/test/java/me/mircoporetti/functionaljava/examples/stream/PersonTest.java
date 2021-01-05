package me.mircoporetti.functionaljava.examples.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private List<Person> people;

    @BeforeEach
    void setUp() {
        people = Arrays.asList(
                new Person("Mirco", Gender.MALE),
                new Person("Laura", Gender.FEMALE),
                new Person("Jessica", Gender.FEMALE),
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
        List<Integer> expected = List.of(5,5,7,7);

        List<Integer> result =
                people.stream()
                        .map(person -> person.name)
                        .map(String::length).collect(Collectors.toList());

        assertEquals(expected, result);
    }

    @Test
    void allFemalePeopleNames() {
        List<String> expected = List.of("Laura","Jessica","Valeria");

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

    @Test
    void orderByName() {
        List<Person> expected = Arrays.asList(
                new Person("Jessica", Gender.FEMALE),
                new Person("Laura", Gender.FEMALE),
                new Person("Mirco", Gender.MALE),
                new Person("Valeria", Gender.FEMALE)
        );
        List<Person> result = people.stream().sorted(Comparator.comparing(person -> person.name)).collect(Collectors.toList());

        assertEquals(expected, result);
    }

    @Test
    void groupByGender() {
        List<Person> expectedBoys = Collections.singletonList(new Person("Mirco", Gender.MALE));

        List<Person> expectedGirls = Arrays.asList(
                new Person("Laura", Gender.FEMALE),
                new Person("Jessica", Gender.FEMALE),
                new Person("Valeria", Gender.FEMALE)
        );

        Map<Gender, List<Person>> groupedPeople = people.stream().collect(Collectors.groupingBy(person -> person.gender));

        assertEquals(expectedBoys, groupedPeople.get(Gender.MALE));
        assertEquals(expectedGirls, groupedPeople.get(Gender.FEMALE));
    }

    @Test
    void orderedFemaleNames() {
        List<String> expected = List.of("Jessica","Laura","Valeria");

        List<String> result = people.stream()
                .filter(person -> person.gender.equals(Gender.FEMALE))
                .sorted(Comparator.comparing(person -> person.name))
                .map(person -> person.name)
                .collect(Collectors.toList());

        assertEquals(expected, result);
    }

    private static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) && gender == person.gender;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, gender);
        }
    }

    private enum Gender {
        MALE,
        FEMALE,
        UNKNOWN
    }
}


