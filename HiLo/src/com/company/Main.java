package com.company;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static int getRandomNumber(){
        Random rand = new Random();
        return rand.nextInt(13)+1;
    }
    public static int modifyPoints(int pointsRisked, boolean didTheyWin){
        if(didTheyWin == true){
            return pointsRisked*2;
        }
        else{
            return pointsRisked*-1;
        }
    }
    public static void iWin(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nYou have ran out of points.");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nIt is true that the house always wins.");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nGoodbye.");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        int points = 1000;
	    int pointsBet; // Amount of points risked
	    int guess = 0; // 0 for Low, 1 for High
        int result;
        System.out.println("High-Low Game");
	    System.out.println("RULES: \n Numbers 1-6 are considered Low\n Numbers 8-13 are considered High\n 7 is neither High nor Low\n");
	    while(points>0){
	        Scanner input = new Scanner(System.in);
	        System.out.println("You have " + Integer.toString(points) + " points.\n");
	        do {
                System.out.println("How many points would you like to bet?");
                pointsBet = input.nextInt();
                if(pointsBet > points){
                    System.out.println("You cannot bet more points that you have.");
                    System.out.println("You have " + Integer.toString(points) + " points.");
                }
            }while(pointsBet > points);
	        System.out.println("\nMake a guess! (1 = High, 0 = Low)");
	        guess = input.nextInt();
	        System.out.println("Rolling the dice!\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = getRandomNumber();
	        System.out.println("Number is: " + Integer.toString(result));
	        if(guess == 0 && result < 7 || guess == 1 && result > 7){
	            System.out.println("You win!\n");
	            points = points + modifyPoints(pointsBet, true);
            }else{
	            System.out.println("You lose. Better luck next time!\n");
                points = points + modifyPoints(pointsBet, false);
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	    iWin();

    }
}
