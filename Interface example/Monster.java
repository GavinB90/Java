package com.gav;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Gav on 05-May-16.
 */
public class Monster implements ISimple {
    private String monsterName;
    private int monsterHP;
    private int monsterLevel;

    public Monster(String monsterName, int monsterHP, int monsterLevel) {
        this.monsterName = monsterName;
        this.monsterHP = monsterHP;
        this.monsterLevel = monsterLevel;
    }

    @Override
    public List<String> write() {
        return null;
    }

    @Override
    public void read(List<String> savedValues) {

    }

    @Override
    public String toString() {
        return "Player name: " + this.monsterName + "\n" +
                "Player HP: " + this.monsterHP + "\n" +
                "Player Level:" + this.monsterLevel;
    }
}
