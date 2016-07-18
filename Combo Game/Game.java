package com.gav;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by Gav on 13-May-16.
 */
public class Game {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Integer> numbers = new ArrayList<Integer>();
    private ArrayList<Integer> copyOfNumbers = new ArrayList<Integer>();
    private int sum;


    public Game(boolean random, Player player, boolean restartGame) {

        if(random){
            for(int i = 0; i < 6; i++){
                int randomNumber = (int) (Math.random()*20);
                randomNumber = checkNumber(randomNumber) ? randomNumber + 1 : randomNumber;
                this.numbers.add(i, randomNumber);
            }
            copyArray(numbers, copyOfNumbers);
        }else if(restartGame){
            if(copyOfNumbers.isEmpty()){
                System.out.println("No game existed before, please select another option!\n");
                return;
            }
            copyArray(copyOfNumbers, numbers);

        }else {
            startOver(numbers);
            System.out.println("----------------------------------------------------");
            System.out.println("Adding numbers:");
            for(int i = 0; i < 6; i++){
                System.out.println("Please enter a number: ");
                int newNumber = scanner.nextInt();
                this.numbers.add(i, newNumber);
            }
        }
        playGame();
    }

    private void playGame(){
        boolean gameOver = false;
        System.out.println("----------------------------------------------------");
        System.out.println("Welcome to the game of combos! The aim of the game is to use math\n to " +
                "get the eventual sum to equal the last remainding number from\n" +
                " the original 6.\n");
        while (!gameOver){
            
            System.out.println("Please enter a number from these: " + numbers);
            int firstNumber = scanner.nextInt();
            System.out.println("Please select a sign for the sum (/*+-):");
            String sign = scanner.next();
            System.out.println("Please enter a number from these: " + numbers);
            int secondNumber = scanner.nextInt();
            if(sumOfNumbers(firstNumber, secondNumber, sign) >= 0){
                if(numbers.size() == 1){
                    if(numbers.get(0) == this.sum){
                        System.out.println("Congratulations! You managed to beat the game!\n");
                        System.out.println("");
                    }else{
                        System.out.println("Unfortunately you didnt beat the game this time. Game over!\n");
                    }
                    gameOver = true;
                }

            }

        }
    }

    private int sumOfNumbers(int firstNumber, int secondNumber, String sign){
        int signNo =0;
        if(!checkNumber(firstNumber) && sum != firstNumber){
            System.out.println("Numbers are not in the list.");
            return -1;
        }else if(!checkNumber(secondNumber) && sum != secondNumber){
            System.out.println("Numbers are not in the list.");
            return -1;
        }
        if(sign.length() > 1 || sign.length() <= 0){
            System.out.println("Sign is incorrect, please try again!");
            return -1;
        }else {
            if(sign.equals("/")){
                signNo = 1;
            }else if(sign.equals("*")){
                signNo = 2;
            }else if(sign.equals("+")){
                signNo = 3;
            }else if(sign.equals("-")){
                signNo = 4;
            }

            if(sum != firstNumber){
                int indexFN = getIndex(firstNumber);
                numbers.remove(indexFN);
            }
            if(sum != secondNumber) {
                int indexSN = getIndex(secondNumber);
                numbers.remove(indexSN);
            }

            switch (signNo){
                case 1:
                    this.sum = firstNumber / secondNumber;
                    break;
                case 2:
                    this.sum = firstNumber * secondNumber;
                    break;
                case 3:
                    this.sum = firstNumber + secondNumber;
                    break;
                case 4:
                    this.sum = firstNumber - secondNumber;
                    break;
                default:
                    System.out.println("Sign is incorrect, please try again!");
                    return -1;
            }
        }

        System.out.println("Last sum = " + sum);
        

        return 1;
    }

    private int getIndex(int inputNumber){
        for(int i = 0; i < numbers.size(); i++){
            if(inputNumber == numbers.get(i)){
                return i;
            }
        }
        return -1;
    }

    private boolean checkNumber(int inputNumber){
        if(!this.numbers.isEmpty()){
            for (int i: this.numbers) {
                if(i == inputNumber){
                    return true;
                }
            }
        }
        return false;
    }

    private void startOver(ArrayList<Integer> arrayList){
        if(!numbers.isEmpty()){
            for(int i = 0; i <= arrayList.size(); i++){
                arrayList.remove(i);
            }
        }
    }

    public void restartGame(){
        if(copyOfNumbers.isEmpty()){
            System.out.println("Unable to restart game, previous game may not have existed.");
            return;
        }
        copyArray(copyOfNumbers, numbers);
    }

    private ArrayList copyArray(ArrayList<Integer> arrayList, ArrayList<Integer> arraylistCopy){
        for (int i: arrayList) {
            arraylistCopy.add(i);
        }
        return arraylistCopy;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<Integer> getCopyOfNumbers() {
        return copyOfNumbers;
    }

    public void setCopyOfNumbers(ArrayList<Integer> copyOfNumbers) {
        this.copyOfNumbers = copyOfNumbers;
    }


}
