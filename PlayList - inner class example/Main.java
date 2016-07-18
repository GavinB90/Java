package com.gav;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album joyAlbum = new Album("Album one");

        joyAlbum.addSong("Give it all", 3.30);
        joyAlbum.addSong("Like the angel", 3.46);
        joyAlbum.addSong("Promises", 3.55);
        joyAlbum.addSong("To Zanarkand", 5.46);
        joyAlbum.addSong("Lose Yourself", 2.30);
        joyAlbum.addSong("Gravity", 4.22);
        joyAlbum.addSong("Simple man", 6.34);
        joyAlbum.addSong("Downtown", 3.49);
        joyAlbum.addSong("Shake it off", 3.44);
        joyAlbum.addSong("Geronimo", 3.09);
        joyAlbum.addSong("Photograph", 3.58);
        albums.add(joyAlbum);

        Album nameOfAlbum = new Album("Album two");
        nameOfAlbum.addSong("Song one", 4.26);
        nameOfAlbum.addSong("Song two", 3.56);
        nameOfAlbum.addSong("Song three", 1.35);
        nameOfAlbum.addSong("Jump for joy", 2.37);
        nameOfAlbum.addSong("Allelujah", 6.40);
        nameOfAlbum.addSong("Firefly", 3.50);
        nameOfAlbum.addSong("Follow you", 2.87);
        nameOfAlbum.addSong("Dance, dance", 3.44);
        albums.add(nameOfAlbum);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("Promises", playList);
        albums.get(0).addToPlayList("Like the angel", playList);
        albums.get(0).addToPlayList("Simple man", playList);
        albums.get(0).addToPlayList("Give it all", playList);

        albums.get(1).addToPlayList("Jump for joy", playList);
        albums.get(1).addToPlayList("Firefly", playList);
        albums.get(1).addToPlayList("Follow you", playList);


        play(playList);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> playListIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + playListIterator.next().toString());
        }
        printActions();
        while (!quit) {

            System.out.println("\nEnter action: (6 to show avalable actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (playListIterator.hasNext()) {
                            playListIterator.next();
                        }
                        goingForward = true;
                    }
                    if (playListIterator.hasNext()) {
                        System.out.println("Now playing: " + playListIterator.next().toString());
                    } else {
                        System.out.println("End of playlist.");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (playListIterator.hasPrevious()) {
                            playListIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (playListIterator.hasPrevious()) {
                        System.out.println("Now playing: " + playListIterator.previous().toString());
                    } else {
                        System.out.println("First song of the play list is playing.");
                        goingForward = true;
                    }
                    break;
                case 3:
                        if(goingForward) {
                            if (playListIterator.hasPrevious()) {
                                System.out.println("Now playing: " + playListIterator.previous().toString());
                                goingForward = false;
                            }
                        } else {
                            if (playListIterator.hasNext()) {
                                System.out.println("Now playing: " + playListIterator.next().toString());
                                goingForward = true;
                            }
                        }
                    break;
                case 4:
                    displayListOfSongs(playList);
                    break;
                case 5:
                    printActions();
                    break;

            }
        }

    }

    private static void printActions(){
        System.out.println( "\nAvailable actions:\npress");
        System.out.println( "0 - to quit\n"+
                "1 - to go to the next song\n" +
                "2 - to go back to previous song\n"+
                "3 - to replay the song\n"+
                "4 - to display a list of the songs in the playlist\n"+
                "5 - to print a list of available actions");
        System.out.println("Choose your action: ");
    }

    private static void displayListOfSongs(LinkedList<Song> playList){
        System.out.println("Play list contains:");
        for(Song song : playList){
            System.out.println(song.toString());
        }
    }
}
