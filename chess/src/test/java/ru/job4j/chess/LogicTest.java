package ru.job4j.chess;

import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import org.junit.Test;

public class LogicTest{

    @Test(expected = OccupiedCellException.class)
    public void testMove() throws OccupiedCellException, FigureNotFoundException{
        Figure figure1 = new BishopBlack(Cell.C1);
        Figure figure2 = new BishopBlack(Cell.E3);
        Logic logic = new Logic();
        logic.add(figure1);
        logic.add(figure2);
        logic.move(figure1.position(), Cell.G5);
    }
}