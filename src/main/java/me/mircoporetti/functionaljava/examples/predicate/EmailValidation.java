package me.mircoporetti.functionaljava.examples.predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EmailValidation {

    public static Predicate<String> validate = mail -> mail.contains("@");

    public static Predicate<String> checkIsDotCom = mail -> mail.endsWith(".com");

    public static BiPredicate<String, String> checkSameDomain = (firstMail, secondMail) ->
            firstMail.split("@")[1].equals(secondMail.split("@")[1]);
}
