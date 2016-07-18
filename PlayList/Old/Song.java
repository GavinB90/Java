package com.gav;

/**
 * Created by Gav on 24-Apr-16.
 */
public class Song {
    private String name;
    private double durationOfSong;

    public Song(String name, double durationOfSong) {
        this.name = name;
        this.durationOfSong = durationOfSong;
    }

    public String getName() {
        return name;
    }

    public double getDurationOfSong() {
        return durationOfSong;
    }
}
