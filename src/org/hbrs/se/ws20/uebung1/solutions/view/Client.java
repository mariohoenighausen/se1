package org.hbrs.se.ws20.uebung1.solutions.view;

import org.hbrs.se.ws20.uebung1.solutions.control.Translator;
import org.hbrs.se.ws20.uebung1.solutions.control.factory.TranslatorFactory;

public class Client {

	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */
	public void display( int aNumber ){
		// In dieser Methode soll die Methode translateNumber 
		// mit dem übergegebenen Wert der Variable aNumber 
		// aufgerufen werden.
		// Strenge Implementierung gegen das Interface Translator gewuenscht!

		// Referenz aktiv beziehen
		Translator translator = TranslatorFactory.createGermanTranslator(); // new GermanTranslator();
		String result = translator.translateNumber( aNumber );

		System.out.println("Das Ergebnis der Berechnung: " +
				"[das Ergebnis an dieser Stelle]" + result );

		translator = TranslatorFactory.createEnglishTranslator();
		result = translator.translateNumber( aNumber );

		// System.out.println("Ergebnis auf Englisch: " + result );

	}
}




