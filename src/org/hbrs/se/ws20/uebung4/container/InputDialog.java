package org.hbrs.se.ws20.uebung4.container;

import org.hbrs.se.ws20.uebung4.container.Container;
import org.hbrs.se.ws20.uebung4.model.PersistenceException;
import org.hbrs.se.ws20.uebung4.model.UserStory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputDialog {
    private final Scanner sc = new Scanner(System.in);
    private final Container c = Container.getInstance();
    public void enter2(){
        //trying regex to only accept only correct inputs
    }
    public void enter(){
        int ID = 0;
        String description = "",acceptanceCriteria = "";
        int[] array = new int[4];
        System.out.println("Please state a UserStories attributes seperated by a comma like this: ID,Description,Details,AcceptancyCriteria,RelValue,RelPunish,RelRisc,RelEffort");
        String input = "";
        int idx = 0;
        String[] sepInput = new String[8];
        try {
            input = sc.nextLine();
            sepInput = input.split(",");
            ID = Integer.parseInt(sepInput[0]);
            description = sepInput[1];
            acceptanceCriteria = sepInput[2];
            array[0] = Integer.parseInt(sepInput[3]);
            array[1] = Integer.parseInt(sepInput[4]);
            array[2] = Integer.parseInt(sepInput[5]);
            array[3] = Integer.parseInt(sepInput[6]);
        }
        catch(java.util.NoSuchElementException nSEEX){
            System.out.println("There was a problem with your input please try it again.");
        }
        catch(NumberFormatException nFEX ){
            System.out.println("There was a problem with the conversion of one of the stated numbers+" +
                    "please state whole numbers");
        }
        if(ID < 0 || array[0] < 0 || array[1] < 0 || array[2] < 0 || array[3] < 0 ){
            System.out.println("Please try again and state whole numbers bigger zero");
        }else{
            try{
                c.addMember(new UserStory(ID,description,acceptanceCriteria,array));
            }
            catch(ContainerException cEX){
                System.out.println(cEX.getMessage());
            }
        }
    }
    public void store(){
        try{
            c.store();
        }
        catch(PersistenceException pEX){

        }
    }
    public void load(String param){
        try{
            c.load(param);
        }
        catch(PersistenceException pEX){
        }
    }
    public void dump(){
        try{
            c.dump();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void exit(){
        System.exit(0);
    }
    public void help(){
        Map<String, String> explanations = new HashMap<>(7);
        explanations.put("enter","Please enter a UserStory \n enter id,description,acceptanceCriteria,relValue,relPunish,relRisk,relEffort");
        explanations.put("store","Saves the Userstories in a file");
        explanations.put("load","Loads the Userstories from a file");
        explanations.put("dump","Displays the Userstories in a table");
        explanations.put("exit","Exits the program, all your unsaved changes will be discarded");
        explanations.put("help","State help [functionality] or just help for general help");
        for(Map.Entry<String,String> entry : explanations.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    public void splashMessage(){
        System.out.println("UsrStry v. 0.1");
        help();
    }
    public void commandPrompt(){
        String cmd = "";
        String param = " ";
        String input = " ";
        String[] sep = {" ","p"};
        try{
            System.out.print("> ");
            cmd = sc.next();
        }
        catch(Exception ex){
            ex.getStackTrace();
        }
        //sep = input.split(" ");
        //identifyCommand(sep[0],sep[1]);
        identifyCommand(cmd);
    }
    public void identifyCommand(String cmd){
        String lowerCased = cmd.toLowerCase();
        switch(lowerCased){
            case "enter":
                enter();
                break;
            case "store":
                store();
                break;
            case "load":
                String param = sc.next();
                load(param.toLowerCase());
                break;
            case "dump":
                dump();
                break;
            case "help":
                help();
                break;
            case "exit":
                exit();
                break;
            default:
                System.out.println("Please state a valid command");
                break;
        }

    }

}
