package blackboxtest;

import org.hbrs.se.ws20.uebung1.control.GermanTranslator;
import org.hbrs.se.ws20.uebung1.control.Translator;
import org.hbrs.se.ws20.uebung1.view.Client;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BlackBoxTest {
    /**
     * method to Test the "output" (respectively the console output) of the method display of the CLient class
     *  Creates a text file with the output of the standard output console and checks whether it matches the expected result.
     *
     */
    public void displayTest() {
        Client c = new Client();
        Translator g = new GermanTranslator();
        try {
            PrintStream out = new PrintStream("output.txt");
            System.setOut(out);
            c.display(1);
            c.display(10);
            c.display(11);
            c.display(-1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        PrintStream ps = new PrintStream(new FileOutputStream(FileDescriptor.out));

        try {
            System.setOut(ps);
            Scanner sc = new Scanner(new File("output.txt"));
            List<String> outScan = new LinkedList<>();
            while (sc.hasNext()) {
                outScan.add(sc.nextLine());
            }
            System.out.println(("Das Ergebnis der Berechnung: eins").equals(outScan.get(0)));
            System.out.println(("Das Ergebnis der Berechnung: zehn").equals(outScan.get(1)));
            System.out.println(("Das Ergebnis der Berechnung: Übersetzung der Zahl " + 11 + " nicht möglich " + g.version).equals(outScan.get(2)));
            System.out.println(("Das Ergebnis der Berechnung: Übersetzung der Zahl " + -1 + " nicht möglich " + g.version).equals(outScan.get(3)));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
