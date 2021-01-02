package me.mircoporetti.functionaljava.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class IntegerManipulation {

    public static Function<Integer, Integer> incrementByOne = n -> n + 1;

    public static Function<Integer, Integer> multiplyBy10 = n -> n * 10;

    public static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBy =
            (toBeIncrementedByOne, multiplier) -> (toBeIncrementedByOne + 1) * multiplier;
}
