package org.hbrs.se.ws20.uebung1.control;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {
    GermanTranslator g;
    @BeforeEach
    void setUp(){
        g = new GermanTranslator();
    }
    @AfterEach
    void tearDown() {
        g = null;
    }
    @Test
    void translateNumber(){
        // x < 1
        assertEquals("Übersetzung der Zahl " + -1 +" nicht möglich "+ g.version,g.translateNumber(-1));
        // 1 ≤ x ≤ 10
        assertEquals("eins",g.translateNumber(1));
        // x > 10
        assertEquals("Übersetzung der Zahl " + 11 +" nicht möglich "+ g.version,g.translateNumber(11));
        // x < 1 (x == 0)
        assertEquals("Übersetzung der Zahl " + 0 +" nicht möglich " + g.version,g.translateNumber(0));
        // 1 ≤ x ≤ 10
        assertEquals("zwei",g.translateNumber(2));
    }
    @Test
    void setDate(){
        g.setDate("Nov/2020");
        assertEquals("Nov/2020",g.date);
    }
}