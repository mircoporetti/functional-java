package me.mircoporetti.functionaljava;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static me.mircoporetti.functionaljava.IntegerManipulation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerManipulationTest {

    @Test
    void increaseByOne() {
        assertEquals(2, incrementByOne.apply(1));
    }

    @Test
    void multiplyBy10() {
        assertEquals(20, multiplyBy10.apply(2));
    }

    @Test
    void increaseByOneAndMultiplyBy10_usingChain() {
        Function<Integer, Integer> incrementByOneAndMultiplyBy10 = incrementByOne.andThen(multiplyBy10);

        assertEquals(30, incrementByOneAndMultiplyBy10.apply(2));
    }

    @Test
    void incrementByOneAndMultiplyBy_usingBiFunction() {
        assertEquals(15, incrementByOneAndMultiplyBy.apply(2, 5));
    }
}