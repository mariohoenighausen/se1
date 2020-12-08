package org.hbrs.se.ws20.uebung2;

import org.hbrs.se.ws20.uebung3.persistence.PersistenceException;
import org.hbrs.se.ws20.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se.ws20.uebung3.persistence.PersistenceStrategyStream;

import java.util.LinkedList;
import java.util.List;


public class Container {
    private LinkedList<Member> memberList;
    private static Container instance; //TODO unnötiger Speicheraufwand, sollte zur Überprüfung in der getInstance Methode initialisiert werden.
    private PersistenceStrategyStream<Member> pSS;
    private static final Object lock = new Object();
    /*static { // ein Static-block, wird ausgeführt, wenn eine Klasse geladen wird
    }*/
    private Container(){
        memberList = new LinkedList<>();
    }
    public void setPersistenceStrategyStream(String filePathLoad,String filePathStore){//TODO: Übergabe einer Strategie (Mongo, oder andere), anstatt Dateipfaden
        this.pSS = new PersistenceStrategyStream<>(filePathLoad,filePathStore);
    }
    public PersistenceStrategy<Member> getPersistenceStrategyStream(){
        return pSS;
    }
    /*public static Container getInstance(){
            return Container.instance;
    }*/

    public static synchronized Container getInstance(){
        synchronized (lock) { // nur ein "Client" kann zur selben Zeit darauf zugreifen.
            if (instance == null) {
                instance = new Container();
            }
        }
        return instance;
    }
    public void store() throws PersistenceException {
        if(pSS == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,"No no strategy available");
        }
        pSS.save(memberList);
    }
    public void load() throws PersistenceException{
        if(pSS == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,"No no strategy available");
        }
        memberList = (LinkedList<Member>) pSS.load();
    }
    public void addMember( Member member )throws ContainerException{
        //memberList.stream().filter(member1 -> member1.getID().equals(member.getID())).findFirst().orElseThrow(new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!"));
        for (Member m : memberList) {
            if(m.getID().equals((member.getID()))) {
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
            }
        }
        memberList.add(member);
    }
    public String deleteMember(Integer id){
        //memberList.stream().filter(member -> member.getID().equals(id)).findFirst().ifPresent(memberList::remove);

        for(Member m : memberList){
            if(m.getID().equals(id)){
                memberList.remove(m);
                return "" + m.toString();
            }
        }
        return "" + -1;
    }
    public List<Member> getCurrentList(){
        return memberList;
    }
    public int size(){
        return memberList.size();
    }
}