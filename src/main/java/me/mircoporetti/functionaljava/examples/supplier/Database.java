package me.mircoporetti.functionaljava.examples.supplier;

import java.util.List;
import java.util.function.Supplier;

public class Database {

    public static Supplier<String> getDbConnectionUrl = () -> "mysql://me.mircoporetti:33060/users";

    public static Supplier<List<String>> getDbConnectionUrls = () ->
            List.of("mysql://me.mircoporetti:33060/users", "mysql://me.mircoporetti:33060/groups");
}
