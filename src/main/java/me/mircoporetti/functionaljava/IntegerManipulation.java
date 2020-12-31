package me.mircoporetti.functionaljava;

import java.util.function.BiFunction;
import java.util.function.Function;

public class IntegerManipulation {

    static Function<Integer, Integer> incrementByOne = n -> n + 1;

    static Function<Integer, Integer> multiplyBy10 = n -> n * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBy =
            (toBeIncrementedByOne, multiplier) -> (toBeIncrementedByOne + 1) * multiplier;
}
