package org.hbrs.se.ws20.uebung9;

public class GlobalConfig {
    private VerificationContext vc;
    public GlobalConfig(VerificationContext vc){
        this.vc = vc;
    }
    public void changeVerificationStrategy(){
        VerificationStrategy vs = null;
        if (IfrsStrategy.isAvailable()){
            vs = new IfrsStrategy();
        }
        else if(SwissGaapFerStrategy.isAvailable()){
            vs = new SwissGaapFerStrategy();
        }
        else if (USGaapStrategy.isAvailable()){
            vs = new USGaapStrategy();
        }
        vc.setVerificationStrategy(vs);
    }
}
