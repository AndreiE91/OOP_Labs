package com.company;

public abstract class GameObject {

    final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1 };

    Coord coord;
    private char symbol;
     Given given;

    public GameObject(Coord coord, char symbol) {
        this.coord = coord;
        this.symbol = symbol;
        given = new Given();
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public abstract void move(char[][] map);
}
