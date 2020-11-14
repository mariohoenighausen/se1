package org.hbrs.se.ws20.uebung2;

import java.util.LinkedList;

public class Container {
    private final LinkedList<Member> memberList;

    public Container(){
        memberList = new LinkedList<>();
    }
    public void addMember( Member member )throws ContainerException{
        for (Member m : memberList) {
            if (m.getID().equals((member.getID()))) {
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
            }
        }
        /*if (memberList.contains(member)){
            throw new ContainerException("Das Member-Objekt mit der ID "+ member.getID() +" ist bereits vorhanden!");
        }*/
        memberList.add(member);
    }

    public static void main(String[] args) {
        Container c = new Container();
        try{
            c.addMember(new Factory(0));
            c.addMember(new Factory(1));
            c.dump();
            System.out.println(c.size());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public String deleteMember(Integer id){
            for(Member m : memberList){
                if(m.getID().equals(id)){
                    Member x = m;
                    memberList.remove(m);

                    return "" + x.toString();
                }
            }
            return "" + -1;
            //String gibt keinen StackTrace aus bzw. keine genaue Fehlererkennung möglich
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
