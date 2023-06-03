package com.company;

public class Hawk extends GameObject {
    private boolean hasStoppedMoving;

    public Hawk(Coord coord, char symbol) {
        super(coord, symbol);
    }

    @Override
    public void move(char[][] map) {
        Coord[] coordsStone = given.getNearest(getCoord(), map, 'W');
        Coord[] coordsRodent = given.getNearest(getCoord(), map, 'R');
        Coord towardsStone = given.findNewStep(map, 'H', 'W', getCoord(), coordsStone[0]);
        Coord towardsRodent = given.findNewStep(map, 'H', 'R', getCoord(), coordsRodent[0]);

        if (getCoord().getDistance(getCoord(), towardsRodent) < getCoord().getDistance(getCoord(), towardsStone)) {

            //eat Rodent
            setCoord(towardsRodent);
        } else {
            //grab wander-stone
            setCoord(towardsStone);
        }
    }

    public boolean hasStoppedMoving() {
        return hasStoppedMoving;
    }

    public void stopMoving() {
        this.hasStoppedMoving = true;
    }
}
