package com.gav;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Gav on 27-Apr-16.
 */
public class Album {
    private String albumName;
    private SongList songs = new SongList();

    public Album(String albumName) {
        this.albumName = albumName;
        this.songs = new SongList();
    }



    public boolean addToPlayList(String songName, LinkedList<Song> playList){
        Song checkedSong = this.songs.findSong(songName);
        if(checkedSong != null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + songName + " is not in this album.");
        return false;
    }

    public boolean addSong(String songName, double duration){
        return this.songs.addSong(songName, duration);
    }


    public class SongList {
        private ArrayList<Song> album;

        public SongList() {
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


    }
}
