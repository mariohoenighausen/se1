package org.hbrs.se.ws20.uebung2;

import java.util.LinkedList;

public class Container {
    private final LinkedList<Member> memberList;

    public Container(){
        memberList = new LinkedList<>();
    }
    public void addMember( Member member )throws ContainerException{
        for (Member m : memberList) {
            if(m.getID().equals((member.getID()))) {
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
            }
        }
        /*if (memberList.contains(member)){
            throw new ContainerException("Das Member-Objekt mit der ID "+ member.getID() +" ist bereits vorhanden!");
        }*/
        memberList.add(member);
    }
    public String deleteMember(Integer id){
            for(Member m : memberList){
                if(m.getID().equals(id)){
                    memberList.remove(m);
                    return "" + m.toString();
                }
            }
            return "" + -1;
            //String gibt keinen StackTrace aus bzw. keine genaue Fehlererkennung möglich
        // wird nicht als Fehler anerkannt, sondern als valide Stringrückgabe
        //Behandlung wie bei einer Exception durch catch nicht möglich
        //nur mit mehr Kontrollfluss z.B. einem If statement, dass den String prüft sind bessere behandlung möglich aber umständlich
    }
    public void dump(){
        for(Member m :memberList){
            System.out.println(m.toString());
        }
    }
    public int size(){
        return memberList.size();
    }
}
