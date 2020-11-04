package org.hbrs.se.ws20.uebung1.view;
import org.hbrs.se.ws20.uebung1.control.Translator;
import org.hbrs.se.ws20.uebung1.control.Factory;
import org.hbrs.se.ws20.uebung1.control.GermanTranslator;

public class Client {

	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */
	public void display( int aNumber ){
		// In dieser Methode soll die Methode translateNumber 
		// mit dem übergegebenen Wert der Variable aNumber 
		// aufgerufen werden.
		// Strenge Implementierung gegen das Interface Translator gewuenscht!
		Translator translator = Factory.createGermanTranslator();//new GermanTranslator();
		//maybe something about the preferred language translation which could be gained by the user
		String res = translator.translateNumber(1);
		/*System.out.println("Das Ergebnis der Berechnung: " +
				"[das Ergebnis an dieser Stelle]" );*/
		System.out.println("Das Ergebnis der Berechnung: " + res);
	}
}




