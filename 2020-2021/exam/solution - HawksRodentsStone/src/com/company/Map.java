package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Map {
    public int MAX_COLUMN;
    public int MAX_ROW;
    private char[][] map;
    private Given given;

    private boolean gameOver = true;

    private List<GameObject> movableObjects;
    private List<WanderStone> wanderStones;
    private List<WanderStone> removableWanderStones;
    private List<GameObject> removableObjects;

    public Map()
    {
        File f = null;
        FileReader fr = null;
        movableObjects = new ArrayList<>();
        removableObjects = new ArrayList<>();
        wanderStones = new ArrayList<>();
        removableObjects = new ArrayList<>();
        given = new Given();
        try
        {
            f = new File("D:\\Documents\\UTCN\\Anul II\\SEM I\\OOP\\Exam\\ExamProblem\\src\\com\\company\\FirsHR.txt");
            fr = new FileReader(f);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("No FirsHR.txt");
            System.exit(1);
        }
        Scanner sc = new Scanner(fr);
        try
        {
            readMap(sc);
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Bad configuration");
            System.exit(1);
        }
        catch (IllegalStateException e)
        {
            System.out.println("Input error");
            System.exit(2);
        }
    }

    public void readMap(Scanner sc) {
        String line = sc.nextLine();
        String delim = " ";
        String[] sizes = line.split(delim);
        MAX_ROW = Integer.parseInt(sizes[0]);
        MAX_COLUMN = Integer.parseInt(sizes[1]);
        map = new char[MAX_ROW][MAX_COLUMN];
        for (int i = 0; i < MAX_ROW; i++) {
            line = sc.nextLine();
            for (int j = 0; j < MAX_COLUMN; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        readSymbols();
    }

    public void readSymbols() {
        Coord[] coords = given.readAny(map, 'H');
        for (Coord coord : coords) {
            movableObjects.add(new Hawk(coord, 'H'));
        }
        coords = given.readAny(map, 'R');
        for (Coord coord : coords) {
            movableObjects.add(new Rodent(coord, 'R'));
        }
        coords = given.readWanderStones(map);
        for (Coord coord : coords) {
            wanderStones.add(new WanderStone(coord));
        }
    }

    public void doStep() {
        moveHawks();
        eatRodent();
        grabWanderStone();
        moveRodents();
    }

    public void moveHawks() {
        for (GameObject o : movableObjects) {
            if (o.getClass().getName().equals("Hawk")) {
                o.move(map);
            }
        }
    }

    public void eatRodent() {
        for (GameObject h : movableObjects) {
            if (h.getClass().getName().equals("Hawk")) {
                if (!((Hawk) h).hasStoppedMoving()) {
                    for (GameObject r : movableObjects) {
                        if (r.getClass().getName().equals("Rodent")) {
                            if (r.getCoord() == h.getCoord()) {
                                removableObjects.add(r);
                                removableObjects.add(h);
                                map[h.getCoord().getRow()][h.getCoord().getColumn()] = '.';
                            }
                        }
                    }
                }
            }
        }
        movableObjects.removeAll(removableObjects);
        removableObjects.clear();
    }

    public void grabWanderStone() {
        for (GameObject h : movableObjects) {
            if (h.getClass().getName().equals("Hawk")) {
                if (!((Hawk) h).hasStoppedMoving()) {
                    for (WanderStone w : wanderStones) {
                        if (w.getCoord() == h.getCoord()) {
                            removableWanderStones.add(w);
                            map[h.getCoord().getRow()][h.getCoord().getColumn()] = 'H';
                            ((Hawk) h).stopMoving();
                        }
                    }
                }
            }
        }
    }

    public void moveRodents() {
        for (GameObject r : movableObjects) {
            if (r.getClass().getName().equals("Rodent")) {
                r.move(map);
            }
        }
    }

    public boolean gameOver() {
        for (GameObject r : movableObjects) {
            if (r.getClass().getName().equals("Rodent")) {
                gameOver = false;
                break;
            } else if (r.getClass().getName().equals("Hawk")) {
                if (!((Hawk) r).hasStoppedMoving()) {
                    gameOver = false;
                    break;
                }
            }
        }
        if (!wanderStones.isEmpty()) gameOver = false;

        return gameOver;
    }

    public void fillForest() {
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COLUMN; j++) {
                map[i][j] = '.';
            }
        }
    }

    public void printElements() {
        for (GameObject o : movableObjects) {
            if (o.getClass().getName().equals("Hawk")) {
                map[o.getCoord().getRow()][o.getCoord().getColumn()] = 'H';
            } else if (o.getClass().getName().equals("Rodent")) {
                map[o.getCoord().getRow()][o.getCoord().getColumn()] = 'R';
            }
        }

        for (WanderStone w : wanderStones) {
            map[w.getCoord().getRow()][w.getCoord().getColumn()] = 'W';
        }
    }

    public void printBoard() {
        fillForest();
        printElements();
        System.out.println();
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COLUMN; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
