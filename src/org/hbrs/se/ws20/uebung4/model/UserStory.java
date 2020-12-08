package org.hbrs.se.ws20.uebung4.model;

public class UserStory{
    private final Integer ID;
    private String description;
    private String details;
    private String acceptancyCriteria;
    private double prio;
    private int relValue;
    private int relPunish;
    private int relRisc;
    private int relEffort;

    public UserStory(int ID,String description,String acceptancyCriteria, int[] nums){
        this.ID = ID;
        this.description = description;
        this.acceptancyCriteria = acceptancyCriteria;
        relValue = nums[0];
        relPunish = nums[1];
        relRisc = nums[2];
        relEffort = nums[3];
    }
    public double getPrio() {
        return prio;
    }
    public void setPrio(){
        prio = (double)(relValue+relPunish)/(relEffort+relRisc);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAcceptancyCriteria() {
        return acceptancyCriteria;
    }

    public void setAcceptancyCriteria(String acceptancyCriteria) {
        this.acceptancyCriteria = acceptancyCriteria;
    }

    public Integer getID() {
        return ID;
    }

    public int getRelValue() {
        return relValue;
    }

    public void setRelValue(int relValue) {
        if(relValue < 0){
            throw new IllegalArgumentException();
        }
        this.relValue = relValue;
    }

    public int getRelPunish() {
        return relPunish;
    }

    public void setRelPunish(int relPunish) {
        if(relPunish < 0){
            throw new IllegalArgumentException();
        }
        this.relPunish = relPunish;
    }

    public int getRelRisc() {
        return relRisc;
    }

    public void setRelRisc(int relRisc) {
        if(relRisc < 0){
            throw new IllegalArgumentException();
        }
        this.relRisc = relRisc;
    }

    public int getRelEffort() {
        return relEffort;
    }

    public void setRelEffort(int relEffort) {
        if(relEffort < 0){
            throw new IllegalArgumentException();
        }
        this.relEffort = relEffort;
    }
    /*public void setID(int ID){
        this.ID = ID;
    }*/
    @Override
    public String toString() {
        return "UserStory{" +
                "ID=" + ID +
                ", description='" + description + '\'' +
                ", acceptancyCriteria='" + acceptancyCriteria + '\'' +
                ", prio=" + prio +
                ", relValue=" + relValue +
                ", relPunish=" + relPunish +
                ", relRisk=" + relRisc +
                ", relEffort=" + relEffort +
                '}';
    }

}
