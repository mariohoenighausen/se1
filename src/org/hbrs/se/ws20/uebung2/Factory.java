package org.hbrs.se.ws20.uebung2;

public class Factory implements Member{
    private final Integer id;

    public Factory(int id){
        this.id = id;
    }
    @Override
    public Integer getID() {
        return id;
    }
    public String toString(){
        return "Member (ID = " + id + ")";
    }
}
