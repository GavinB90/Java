package com.gav;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Gav on 27-Apr-16.
 */
public class Album {
    private String albumName;
    private ArrayList<Song> album;

    public Album(String albumName) {
        this.albumName = albumName;
        this.album = new ArrayList<Song>();
    }

    public boolean addSong(String songName, double duration) {
        if (findSong(songName) == null) {
            this.album.add(new Song(songName, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String songName) {
        for (Song checkSong : this.album) {
            if (checkSong.getName().equals(songName)) {
                return checkSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(String songName, LinkedList<Song> playList){
        Song checkedSong = findSong(songName);
        if(checkedSong != null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + songName + " is not in this album.");
        return false;
    }
}
