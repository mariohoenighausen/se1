package org.hbrs.se.ws20.uebung1.control;

import java.util.HashMap;
import java.util.Map;

public class GermanTranslator implements Translator {

	public String date = "Okt/2020"; // Default-Wert

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber( int number ) {
		// [ihr Source Code aus Übung 1-2]
		Map<Integer, String> map = new HashMap<>(10);
		map.put(1,"eins");
		map.put(2,"zwei");
		map.put(3,"drei");
		map.put(4,"vier");
		map.put(5,"fünf");
		map.put(6,"sechs");
		map.put(7,"sieben");
		map.put(8,"acht");
		map.put(9,"neun");
		map.put(10,"zehn");
		return map.getOrDefault(number,"Übersetzung der Zahl " + number +" nicht möglich " + Translator.version);
	}
	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo() {
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: Nov/2020))
	 * Das Datum sollte system-intern gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

	public static void main(String[] args) {

	}
}