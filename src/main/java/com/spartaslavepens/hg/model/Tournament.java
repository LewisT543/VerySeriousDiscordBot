package com.spartaslavepens.hg.model;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

    private List<Contestant> contestants;

    public Tournament() {
        contestants = new ArrayList<>();
    }

    public void addContestants(String contestantNames) {
        
    }

    public void addContestant(String contestantName) {
        contestants.add(new Contestant(contestantName));
    }

}
