package com.gav;

import java.util.ArrayList;

/**
 * Created by Gav on 24-Apr-16.
 */
public class Album {
    private String name;
    private ArrayList<Song> album = new ArrayList<Song>();

    public Album() {
    }

    public Album(String name) {
        this.name = name;
        this.album = new ArrayList<Song>();
    }


    public Song findSongInAlbum(String name){
        for(int i = 0; i < album.size(); i++)   {
            String songName = album.get(i).getName();
            if(songName.equals(name)){
                System.out.println("Song already exists.");
            }else {
                Song song = album.get(i);
                return song;
            }
        }
        return null;
    }

    public String findAlbumName(String songName){
        for(int i = 0; i < album.size(); i++){
            if(album.get(i).getName().equals(songName)){
                return this.name;
            }
        }
        return null;
    }

    public boolean addSong(Song song){
        for (int i = 0; i < album.size(); i++){
            if(song.getName() != null && song.getDurationOfSong() <= 0){
                this.album.add(song);
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getAlbum() {
        return album;
    }
}