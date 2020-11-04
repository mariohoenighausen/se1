package org.hbrs.se.ws20.uebung1.control;

import java.util.HashMap;
import java.util.Map;

public class EnglishTranslator implements Translator {
    @Override
    public String translateNumber(int number) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        map.put(4,"four");
        map.put(5,"five");
        map.put(6,"six");
        map.put(7,"seven");
        map.put(8,"eight");
        map.put(9,"nine");
        map.put(10,"ten");
        return map.get(number);
    }
}
