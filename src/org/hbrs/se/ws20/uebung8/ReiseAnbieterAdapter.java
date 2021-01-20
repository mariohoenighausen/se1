package org.hbrs.se.ws20.uebung8;

public class ReiseAnbieterAdapter  implements HotelSuche {
    private final ReiseAnbieter r;
    public ReiseAnbieterAdapter(ReiseAnbieter r){
        this.r = r;
    }
    public QueryResult executeQueryAdaptee(QueryInput q){
        QueryObject qOIN = transformInput(q);
        QueryObject qOOUT =  transformOutput(qOIN);
        return r.executeQuery(qOOUT);
    }
    private QueryObject transformInput(QueryObject q){
        return new QueryObject();
    }
    private QueryObject transformOutput(QueryObject q){
        return new QueryObject();
    }
}
