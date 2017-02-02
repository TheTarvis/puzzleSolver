package util;

import pieces.Block;
import pieces.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Puzzle {

    //Only use for visualization, takes for ever to run.
    public static void printPuzzle(Block[][] puzzle) {
        for (int i = puzzle.length - 1; i >= 0; i--) {
            for (int j = 0; j < puzzle[i].length; j++) {
                Block block = puzzle[i][j];
                String name = block != null ? " " + block.getName() + " " : " <> ";
                System.out.print(name);
            }
            System.out.println();
        }
    }


    public static void clearPuzzle(Block[][] puzzle) {
        for (int i = puzzle.length - 1; i >= 0; i--) {
            for (int j = 0; j < puzzle[i].length; j++) {
                puzzle[i][j] = null;
            }
        }
    }

    public static ArrayList<Position> findOpenSpots(Object[][] puzzle, Position startPosition) {
        List<Position> positions = new LinkedList<>();

        int y1 = startPosition.getY() == -1 ? 0 : startPosition.getY();

        for (int x = startPosition.getX(); x < puzzle.length; x++) {
            for (; y1 < puzzle[x].length; y1++) {
                if (puzzle[x][y1] == null) {
                    positions.add(new Position(x, y1));
                }
            }
            y1 = 0;
        }

        for (int x = 0; x < startPosition.getX(); x++) {
            for (int y = 0; y < startPosition.getY(); y++) {
                if (puzzle[x][y] == null && !(x == startPosition.getX() && y == startPosition.getY())) {
                    positions.add(new Position(x, y));
                }
            }
        }

        return new ArrayList<>(positions);
    }

}
