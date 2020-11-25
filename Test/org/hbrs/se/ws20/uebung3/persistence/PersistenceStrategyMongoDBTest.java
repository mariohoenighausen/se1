package org.hbrs.se.ws20.uebung3.persistence;

import org.hbrs.se.ws20.uebung2.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PersistenceStrategyMongoDBTest {
    PersistenceStrategyMongoDB<Member> pSSM;
    @BeforeEach
    void setUp() {
        pSSM = new PersistenceStrategyMongoDB<>();
    }

    @AfterEach
    void tearDown() {
        pSSM = null;
    }

    @Test
    void openConnection() {
        assertThrows(PersistenceException.class, ()-> pSSM.openConnection());
    }

    @Test
    void closeConnection() {
        assertThrows(PersistenceException.class, ()-> pSSM.closeConnection());
    }

    @Test
    void save() {
        assertThrows(UnsupportedOperationException.class, ()-> pSSM.save(new LinkedList<Member>()));
    }

    @Test
    void load() {
        assertThrows(UnsupportedOperationException.class, ()-> pSSM.load());
    }
}