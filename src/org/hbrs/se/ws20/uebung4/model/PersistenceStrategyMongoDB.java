package org.hbrs.se.ws20.uebung4.model;

import org.hbrs.se.ws20.uebung4.model.PersistenceException;
import org.hbrs.se.ws20.uebung4.model.PersistenceStrategy;

import java.util.List;

public class PersistenceStrategyMongoDB<UserStory> implements PersistenceStrategy<UserStory> {
    @Override
    public void openConnection() throws PersistenceException {
        try{
            throw new java.lang.UnsupportedOperationException("Not implemented!");
        }catch(UnsupportedOperationException jLUOE){
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable,"Not implemented");
        }
    }

    @Override
    public void closeConnection() throws PersistenceException {
        try{
            throw new java.lang.UnsupportedOperationException("Not implemented!");
        }catch(UnsupportedOperationException jLUOE){
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable,"Not implemented");
        }
        //throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable,"Not implemented");
    }

    @Override
    public void save(List<UserStory> member) {
        throw new java.lang.UnsupportedOperationException("Not implemented!");

    }

    @Override
    public List<UserStory> load() {
        throw new java.lang.UnsupportedOperationException("Not implemented!");
    }
}