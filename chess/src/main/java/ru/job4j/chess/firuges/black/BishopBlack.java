package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {

        int dx, dy;
        if(source.x < dest.x){
            dx = 1;
        } else {
            dx = -1;
        }
        if(source.y < dest.y) {
            dy = 1;
        } else {
            dy = -1;
        }

        Cell[] result = new Cell[8];
        int beginX = source.x;
        int endX = dest.x;
        int beginY = source.y;
        int endY = dest.y;
        int indexInResult = 0;

        while (beginX != endX){
            int nextX = beginX + dx;
            int nextY = beginY + dy;
            if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7){
                return result;
            }
            Cell nextCell = Cell.findBy(nextX, nextY);

            if(nextCell != null){
                result[indexInResult] = nextCell;
                indexInResult++;
                beginX += dx;
                beginY += dy;
            } else {
                throw new IllegalStateException(
                        String.format("Could not way by diagonal from %s to %s", source, dest)
                );
            }
        }


        Cell[] endRedult = Arrays.copyOf(result, indexInResult);

        return endRedult;



    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
