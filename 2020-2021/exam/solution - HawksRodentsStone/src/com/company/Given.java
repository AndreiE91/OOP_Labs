package com.company;

public class Given {

    Coord[] readAny(char[][] map, char symbol) {
        Coord[] coord = new Coord[20];
        int index = 0;
        for (int i = 0; i < 14; i++) {

            for (int j = 0; j < 86; j++) {
                if (map[i][j] == symbol) {
                    coord[index].setRow(i);
                    coord[index].setColumn(j);
                }
            }
            index++;
        }
        return coord;
    }

    Coord[] readWanderStones(char[][] map) {
        Coord[] coord = new Coord[20];
        return coord;
    }

    Coord[] getNearest(Coord me, char[][] map, char type) {
        Coord[] coord = new Coord[20];
        return coord;
    }

    Coord findNewStep(char[][] map, char myType, char targetType, Coord myPos, Coord targetPos) {
        return new Coord();
    }
}
