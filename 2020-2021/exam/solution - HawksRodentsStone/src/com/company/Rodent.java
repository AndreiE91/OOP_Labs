package com.company;

public class Rodent extends GameObject {
    public Rodent(Coord coord, char symbol) {
        super(coord, symbol);
    }

    @Override
    public void move(char[][] map) {
        Coord[] coords = given.getNearest(getCoord(), map, 'W');
        Coord newStep = given.findNewStep(map, 'R', 'W', getCoord(), coords[0]);
        boolean isRodentNearStone = false;
        for (int dir = 0; dir < 8; dir++) {
            int row = getCoord().getRow() + dx[dir];
            int col = getCoord().getColumn() + dy[dir];
            Coord coord = new Coord(row, col);
            if (coord.equals(coords[0])) {
                isRodentNearStone = true;
                break;
            }
        }
        if (!isRodentNearStone) {
            map[getCoord().getRow()][getCoord().getColumn()] = '.';
            setCoord(newStep);
            map[getCoord().getRow()][getCoord().getColumn()] = 'R';
        } //else it doesn't move, so nothing changes
    }
}
