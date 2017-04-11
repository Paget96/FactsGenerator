package com.alex.alex;

import java.util.ArrayList;
import java.util.Random;

public class FactCatalogue {

    private ArrayList<Fact> facts= new ArrayList<>();
    public FactCatalogue() {
        facts.add(new Fact("In the U.S., if you are delayed by an airline for more than 4 hours for actions within their control (overbooking)"
                ,"you are entitled to 4 times the face vale of the ticket, capped at $1300"));

        facts.add(new Fact("When United Airlines broke a man's $4500 guitar and refused to pay for it in 2009, he wrote a protest song."
        ,"Over the next 4 weeks, United's stock price fell 10%, costing stockholders $180 million."));
    }

    public Fact sayRandomFact(){
        int i = new Random().nextInt(facts.size());
        return facts.get(i);
    }
}
