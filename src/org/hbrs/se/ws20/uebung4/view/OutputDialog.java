package org.hbrs.se.ws20.uebung4.view;

import org.hbrs.se.ws20.uebung4.container.Container;
import org.hbrs.se.ws20.uebung4.model.UserStory;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.stream.Collectors;

public class OutputDialog {
    public void dump(Container c){
        //System.out.println("|ID| | Description | |Acceptancy Criteria | |Priority|");
        c.getCurrentList().stream().sorted(Comparator.comparing(UserStory::getPrio)).collect(Collectors.toList()).forEach(us -> System.out.println("|" + us.getID() + "|" +us.getDescription() + "|" + us.getAcceptancyCriteria() + "|" + us.getPrio()));
        String leftAlignFormat = "| %-2s | %-11s | %-19s | %-19s |%n";
        System.out.format("+----+-------------+---------------------+---------------------+%n");
        System.out.format("| ID | Description | Acceptancy Criteria | Priority            |%n");
        System.out.format("+----+-------------+---------------------+---------------------+%n");
        DecimalFormat df = new DecimalFormat("###.##");
        //TODO: dynamic line breaks for texts after a certain amount of characters
        c.getCurrentList().stream().sorted(Comparator.comparing(UserStory::getPrio)).collect(Collectors.toList()).forEach(us -> System.out.format(leftAlignFormat,us.getID(),us.getDescription(),us.getAcceptancyCriteria(),df.format(us.getPrio())));
        //TODO: Find a better way to arrange attributes in a table https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console
    }
}
