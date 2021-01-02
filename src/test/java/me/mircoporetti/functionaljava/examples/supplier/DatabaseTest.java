package me.mircoporetti.functionaljava.examples.supplier;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void getDbConnectionUrl() {
        assertEquals("mysql://me.mircoporetti:33060/users", Database.getDbConnectionUrl.get());
    }

    @Test
    void getDbConnectionUrls() {
        List<String> urls = Database.getDbConnectionUrls.get();
        assertEquals("mysql://me.mircoporetti:33060/users", urls.get(0));
        assertEquals("mysql://me.mircoporetti:33060/groups", urls.get(1));
    }
}