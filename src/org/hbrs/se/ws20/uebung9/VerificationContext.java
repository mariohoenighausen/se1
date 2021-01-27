package org.hbrs.se.ws20.uebung9;

public class VerificationContext {
    private VerificationStrategy vs;
    public Status executeStrategy(Buchung b){
        return new Status();
    }
    protected void setVerificationStrategy(VerificationStrategy vs){
        this.vs = vs;
    }
}
