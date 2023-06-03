package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Map map = new Map();
        Scanner enter = new Scanner(System.in);
        do {
            map.printBoard();
            System.out.println("Press enter...");
            enter.nextLine();
            map.doStep();
        } while (!map.gameOver());
        System.err.println("GAME OVER");
    }
}
