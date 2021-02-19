package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest extends TestCase {

    public void testPosition() {
    Cell cell = Cell.E3;
    BishopBlack bishopBlack = new BishopBlack(cell);
    Cell testPos = bishopBlack.position();
    assertThat(testPos, is(cell));
    }

    public void testCopy() {
        Cell nextCell = Cell.G2;
        BishopBlack bishopBlackStart = new BishopBlack(Cell.F1);
        Figure bishopBlackFinish = bishopBlackStart.copy(nextCell);
        assertThat(nextCell, is(bishopBlackFinish.position()));
    }

    public void testWay() {
        BishopBlack bishopBlackStart = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlackStart.way(Cell.G5);
        Cell[] expectedCells = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(cells, is(expectedCells));
    }

    public void testwhenIsNotDiagonal() {
    BishopBlack figure = new BishopBlack(Cell.D2);
    boolean responce = figure.isDiagonal(figure.position(),Cell.D6);
    assertThat(false, is(responce));
    }

    public void testwhenIsDiagonal() {
        BishopBlack figure = new BishopBlack(Cell.D2);
        boolean responce = figure.isDiagonal(figure.position(),Cell.H6);
        assertThat(true, is(responce));
    }
}