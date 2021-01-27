package org.hbrs.se.ws20.uebung9;

public class USGaapStrategy implements VerificationStrategy{
    private static boolean isAvailable = false;
    @Override
    public Status verifyBooking(Buchung b) {
        return null;
    }
    public static boolean isAvailable(){
        isAvailable = isAvailable == false ? true : false;
        return isAvailable;
    }
}
