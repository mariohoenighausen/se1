package org.hbrs.se.ws20.uebung4.container;

import org.hbrs.se.ws20.uebung4.model.PersistenceStrategyStream;
import org.hbrs.se.ws20.uebung4.model.UserStory;

public class Main {
    public static void main(String[] args) {
        Container c = Container.getInstance();
        InputDialog id = new InputDialog();
        id.splashMessage();

        c.setPersistenceStrategyStream(new PersistenceStrategyStream<UserStory>());
        while(true){
            id.commandPrompt();
        }
    }
}
