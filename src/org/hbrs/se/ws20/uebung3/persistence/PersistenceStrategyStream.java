package org.hbrs.se.ws20.uebung3.persistence;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {
    private FileInputStream fis;
    private ObjectInputStream ois;
    private FileOutputStream fos;
    private ObjectOutputStream ous;
    private boolean isReading;
    private boolean hasRead;
    private String loadFile;
    private String storeFile;

    public PersistenceStrategyStream(String filepathLoad, String filepathStore) {
        loadFile = filepathLoad;
        storeFile = filepathStore;
    }

    @Override
    public void openConnection() throws PersistenceException {
        if(isReading) {
            try {
                fis = new FileInputStream(loadFile);
                ois = new ObjectInputStream(fis);
            } catch (Exception ex) {
                throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,"s");
            }
        }
        else {
            try {
                fos = new FileOutputStream(storeFile);
                ous = new ObjectOutputStream(fos);
            } catch (Exception ex) {
                throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,"s");
            }
        }
    }

    @Override
    public void closeConnection() throws PersistenceException {
        if(hasRead) {
            try {
                ois.close();
            } catch (Exception ex) {
                throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,"s");
            }
        }
        else{
            try {
                ous.close();
            } catch (Exception ex) {
                throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,"s");
            }
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException  {

        // Writes objects to the output stream
        isReading = false;
        openConnection();
        try{
                ous.writeObject(member); // TODO: abspeichern in eine .ser Datei, anstatt einer Text
        }
        catch(Exception ex){
            throw new PersistenceException(PersistenceException.ExceptionType.SaveFailure,"SaveFailure");
        }
        finally {
            hasRead = false;
            closeConnection();
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     */
    public List<Member> load() throws PersistenceException  {
        List<Member> newListe =  null;
        Object obj = null;
        isReading = true;
        openConnection();
        try{
            obj = ois.readObject();
        }
        catch (Exception ex){
            throw new PersistenceException(PersistenceException.ExceptionType.LoadFailure,"Loadfailure");
        }
        finally{
            hasRead = true;
            closeConnection();
        }

        if (obj instanceof List<?>) {
            newListe = (List) obj;
            return newListe;
        }
        return newListe;
    }
}
