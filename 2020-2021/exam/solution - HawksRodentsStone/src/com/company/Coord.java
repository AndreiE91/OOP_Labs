package com.company;

public class Coord {

    private int row;
    private int column;
    private double distance;

    public Coord() {

    }

    public Coord(int row, int col) {
        this.row = row;
        this.column = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public double getDistance(Coord coord1, Coord coord2) {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
