package com.gav;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Game newGame;

    public static void main(String[] args) {
	// write your code here

        System.out.println("Please enter your name: ");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName);

        boolean quit = false;
        printOptions();
        System.out.println();



        while(!quit){
            System.out.println("Please select an option (4 to print options):");
            int choice = scanner.nextInt();

            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1: // Choice 1: User enters their own numbers.
                    newGame = new Game(false, player, false);
                    break;
                case 2: // Choice 2: User is randomly generated numbers to use.
                    newGame = new Game(true, player, false);
                    break;
                case 3: // Choice 3: User restarts from previous game.
                    newGame = new Game(false, player, true);
                    break;
                case 4:
                    printOptions();
                    break;
                default:
                    System.out.println("Incorrect input! Try again.");
                    break;
            }
        }
    }




    private static void printOptions(){
        System.out.println("You have 5 options to select: " +
                            "\n0. Quit." +
                            "\n1. Play with your own added numbers." +
                            "\n2. Play with randomly generated numbers" +
                            "\n3. Restart game with previous numbers." +
                            "\n4. Print options again.");
    }







}


