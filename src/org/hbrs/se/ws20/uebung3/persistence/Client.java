package org.hbrs.se.ws20.uebung3.persistence;

import org.hbrs.se.ws20.uebung2.Container;
import org.hbrs.se.ws20.uebung2.Factory;

public class Client {
    public static void main(String[] args) {
        Container c = Container.getInstance();
        MemberView m = new MemberView();
        try{
            c.addMember(new Factory(1));
            c.addMember(new Factory(2));
            c.addMember(new Factory(3));
            c.store();
            c.load();
            m.dump(c.getCurrentList());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}