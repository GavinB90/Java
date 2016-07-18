package com.gav;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static LinkedList<Song> playList = new LinkedList<Song>();
    private static ListIterator<Song> playListIterator = playList.listIterator();
    private static boolean goingForward = true;
    private static int indexPosition = 0;
    private static Album album = new Album();

    public static void main(String[] args) {
        boolean quit = false;

        Song song1 = new Song("Give it all", 3.30 );
        Song song2 = new Song("Like the angel", 3.46 );
        Song song3 = new Song("Promises", 3.55 );
        Song song4 = new Song("To Zanarkand", 5.46 );
        Song song5 = new Song("Lose Yourself", 2.30 );
        Song song6 = new Song("Gravity", 4.22 );
        Song song7 = new Song("Simple man", 6.34 );
        Song song8 = new Song("Downtown", 3.49 );
        Song song9 = new Song("Shake it off", 3.44 );
        Song song10 = new Song("Geronimo", 3.09 );
        Song song11 = new Song("Photograph", 3.58 );

        Album album1 = new Album("Amazing");
        Album album2 = new Album("Amazing");
        Album album3 = new Album("Amazing");

        album1.addSong(song1);
        album1.addSong(song2);
        album1.addSong(song3);
        album1.addSong(song4);

        album2.addSong(song5);
        album2.addSong(song6);
        album2.addSong(song7);
        album2.addSong(song8);

        album3.addSong(song9);
        album3.addSong(song10);
        album3.addSong(song11);

        printActions();

        while(!quit){
            System.out.println("\nEnter action: (6 to show avalable actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    quit = true;
                    break;
                case 1:
                    addSongToPlayList();
                    break;
                case 2:
                    nextSong();
                    break;
                case 3:
                    previousSong();
                    break;
                case 4:
                    replaySong();
                    break;
                case 5:
                    displayListOfSongs();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }

    }

    public void displayPlaylistSongs(){

        if(playListIterator.hasNext()){
            while(playListIterator.hasNext()){
                Song song = playList.get(indexPosition);
                System.out.println("Song name: " + song.getName());
                System.out.println("Duration of song: " + song.getDurationOfSong() + " minutes.");
                indexPosition++;
            }
        }else{
            System.out.println("Unable to display play list, this could be because it is empty.");
        }
        indexPosition = 0;
    }

    private static void replaySong(){
        int position = playListIterator.previousIndex();

        if(position < 0){
            Song song = playList.get(position);
            String songName = song.getName();
            System.out.println("Now playing: " + songName);
        }else {
            System.out.println("play list empty.");
        }
    }

    private static void previousSong(){
        if(goingForward){
            if(playListIterator.hasPrevious()){
                playListIterator.previous();
            }
            goingForward = false;
        }
        if(playListIterator.hasPrevious()){
            Song song = playList.get(indexPosition);
            playListIterator.previous();
            System.out.println("Now playing: " + song.getName());
        }else {
            System.out.println("End of playlist.");
        }
    }

    private static void nextSong(){
        if(!goingForward){
            if(playListIterator.hasNext()){
                playListIterator.next();
            }
            goingForward = true;
        }
        if(playListIterator.hasNext()){
            playListIterator.next();
            Song song = playList.get(indexPosition);
            System.out.println("Now playing: " + song.getName());
        }else {
            System.out.println("End of playlist.");
        }
    }

    private static void displayListOfSongs(){
        System.out.println("Play list name: "); //+ playList.getPlayListName());
        if(playListIterator.hasNext()){
            while(playListIterator.hasNext()){
                Song song = playList.get(indexPosition);
                System.out.println("Song name: " + song.getName());
                System.out.println("Duration of song: " + song.getDurationOfSong() + " minutes.");
                indexPosition++;
            }
        }else{
            System.out.println("Unable to display play list, this could be because it is empty.");
        }
        indexPosition = 0;
    }

    private static void addSongToPlayList(){
        System.out.println("Please enter in the songs name: ");
        String songName = scanner.nextLine();

        Song song = album.findSongInAlbum(songName);
        if(song.getName().equals(songName)){
            playList.add(song);
            System.out.println("Added song " + songName + " to play list");
        }else {
            System.out.println("Unable to add song to play list.");
        }
    }

    private static void printActions(){
        System.out.println( "\nAvailable actions:\npress");
        System.out.println( "0 - to quit\n"+
                "1 - to add a song to a playlist\n" +
                "2 - to go to the next song\n" +
                "3 - to go back to previous song\n"+
                "4 - to replay the song\n"+
                "5 - to display a list of the songs in the playlist\n"+
                "6 - to print a list of available actions");
        System.out.println("Choose your action: ");
    }
}
