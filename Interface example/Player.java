package com.gav;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gav on 05-May-16.
 */
public class Player implements ISimple {
    private String playerName;
    private int playerHP;
    private int playerLevel;

    public Player(String playerName, int playerHP, int playerLevel) {
        this.playerName = playerName;
        this.playerHP = playerHP;
        this.playerLevel = playerLevel;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, this.playerName);
        values.add(1, "" + this.playerHP);
        values.add(2, "" + this.playerLevel);

        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && savedValues.size() > 0){
            this.playerName = savedValues.get(0);
            this.playerHP = Integer.parseInt(savedValues.get(1));
            this.playerLevel = Integer.parseInt(savedValues.get(2));
        }
    }

    @Override
    public String toString() {
        return "Player name: " + this.playerName + "\n" +
                "Player HP: " + this.playerHP + "\n" +
                "Player Level: " + this.playerLevel;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerHP() {
        return playerHP;
    }

    public void setPlayerHP(int playerHP) {
        this.playerHP = playerHP;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }
}
