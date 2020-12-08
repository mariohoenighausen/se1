package org.hbrs.se.ws20.uebung4.container;

import org.hbrs.se.ws20.uebung4.model.PersistenceException;
import org.hbrs.se.ws20.uebung4.model.PersistenceStrategy;
import org.hbrs.se.ws20.uebung4.model.UserStory;
import org.hbrs.se.ws20.uebung4.view.OutputDialog;

import java.util.LinkedList;
import java.util.List;


public class Container {
    private LinkedList<UserStory> memberList;
    private static Container instance;
    private PersistenceStrategy<UserStory> pSS;
    private static final Object lock = new Object();
    /*static { // ein Static-block, wird ausgeführt, wenn eine Klasse geladen wird

    }*/
    private Container(){
        memberList = new LinkedList<>();
    }
    public void setPersistenceStrategyStream(PersistenceStrategy<UserStory> strategy){//TODO: Übergabe einer Strategie (Mongo, oder andere), anstatt Dateipfaden
        this.pSS = strategy;
    }
    public PersistenceStrategy<UserStory> getPersistenceStrategyStream(){
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
    public void load(String param) throws PersistenceException{

        if(pSS == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,"No no strategy available");
        }
        LinkedList<UserStory> lIUS = (LinkedList<UserStory>) pSS.load();
        if(param.equals("merge")){
            for(UserStory us :lIUS ){
                mergeLists(us);
            }
        }
        else{
            memberList = lIUS;
        }
    }
    public void mergeLists(UserStory us){
        for (UserStory m : memberList) {
            if(m.getID().equals((us.getID()))) { // man setzt die Stories mit derselben ID auf die der neuen ID
                m.setAcceptancyCriteria(us.getAcceptancyCriteria());
                m.setDescription(us.getDescription());
                m.setDetails(us.getDetails());
                m.setRelEffort(us.getRelEffort());
                m.setRelPunish(us.getRelPunish());
                m.setRelRisc(us.getRelRisc());
                m.setRelValue(us.getRelValue());
                m.setPrio();
            }
            memberList.add(us);
        }
    }
    public void addMember( UserStory member )throws ContainerException {
        for (UserStory m : memberList) {
            if(m.getID().equals((member.getID()))) {
                throw new ContainerException("Das UserStory-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
            }
        }
        memberList.add(member);
    }
    public String deleteMember(Integer id){
        //memberList.stream().filter(member -> member.getID().equals(id)).findFirst().ifPresent(memberList::remove);

        for(UserStory m : memberList){
            if(m.getID().equals(id)){
                memberList.remove(m);
                return "" + m.toString();
            }
        }
        return "" + -1;
    }
    public void dump(){
        OutputDialog od = new OutputDialog();
        od.dump(this);
    }

    public List<UserStory> getCurrentList(){
        return memberList;
    }
    public int size(){
        return memberList.size();
    }
}
