package com.spartaslavepens.hg.model;

import java.util.Random;

public class Match {

    /**
     * Runs a match
     * @param c1 - first contestant
     * @param c2 - second contestant
     * @return the winner (or null, if tied)
     */
    static public Contestant getWinner(Contestant c1, Contestant c2) {
        // TODO: use contestant ability when calculating contestant score
        double c1Score = rng();
        double c2Score = rng();

        if (c1Score > c2Score) {
            return c1;
        } else if (c2Score > c1Score) {
            return c2;
        } else {
            return null; // if tied, return null
        }
    }

    static private Double rng() {
        return new Random(System.currentTimeMillis()).nextDouble();
    }

    static private Double rng(long seed) {
        return new Random(seed).nextDouble();
    }

}
