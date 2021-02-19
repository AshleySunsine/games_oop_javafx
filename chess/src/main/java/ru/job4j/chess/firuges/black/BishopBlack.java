package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.getX() - position.getX());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - position.getX();
        int deltaY = dest.getY() - position.getY();

        for (int index = 0; index < size; index++) {
            if ((deltaX < 0) && (deltaY < 0)) {
                steps[index] = Cell.findBy(position().getX() - (index + 1), position().getY() - (index + 1));
            }
            if ((deltaX > 0) && (deltaY > 0)) {
                steps[index] = Cell.findBy(position().getX() + (index + 1), position().getY() + (index + 1));
            }
            if ((deltaX < 0) && (deltaY > 0)) {
                steps[index] = Cell.findBy(position().getX() - (index + 1), position().getY() + (index + 1));
            }
            if ((deltaX > 0) && (deltaY < 0)) {
                steps[index] = Cell.findBy(position().getX() + (index + 1), position().getY() - (index + 1));
            }
         }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return ((Math.abs(source.getX() - dest.getX())) == (Math.abs(source.getY() - dest.getY())));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
