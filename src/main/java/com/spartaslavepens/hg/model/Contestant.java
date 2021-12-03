package com.spartaslavepens.hg.model;

public class Contestant {

    private String name;
    private boolean alive;
    private int ability;

    public Contestant(String name) {
        this.name = name;
        alive = true;
        ability = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return "Contestant{" +
                "name='" + name + '\'' +
                ", alive=" + alive +
                ", ability=" + ability +
                '}';
    }
}
