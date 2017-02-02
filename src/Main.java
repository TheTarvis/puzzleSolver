import pieces.*;
import util.Puzzle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static ArrayList<AbstractPiece> placedPieces = new ArrayList<>();
    public static Block[][] puzzle = new Block[6][8];
    public static ArrayList<AbstractPiece> pieces = new ArrayList<>();

    public static void main(String[] args) {

        Line line = new Line();
        OneByOne oneByOne = new OneByOne();
        UpsideDownT upsideDownT = new UpsideDownT();
        Cross cross = new Cross();
        Stair stair = new Stair();
        GreenL greenL = new GreenL();
        RedL redL = new RedL();
        BlueL blueL = new BlueL();
        LongZ longZ = new LongZ();
        WeirdT weirdT = new WeirdT();
        WeirdF weirdF = new WeirdF();

        pieces.add(line);
        pieces.add(cross);
        pieces.add(stair);
        pieces.add(greenL);
        pieces.add(weirdT);
        pieces.add(weirdF);
        pieces.add(upsideDownT);
        pieces.add(redL);
        pieces.add(blueL);
        pieces.add(longZ);
        pieces.add(oneByOne);

        solvePuzzle(pieces);

    }

    public static ArrayList<ArrayList<AbstractPiece>> solvePuzzle(List<AbstractPiece> original) {
        if (original.size() == 0) {
            ArrayList<ArrayList<AbstractPiece>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        AbstractPiece firstAbstractPiecelement = original.remove(0);
        ArrayList<ArrayList<AbstractPiece>> returnValue = new ArrayList<>();
        ArrayList<ArrayList<AbstractPiece>> permutations = solvePuzzle(original);

        for (List<AbstractPiece> smallerPermutated : permutations) {
            for (int index = 0; index <= smallerPermutated.size(); index++) {
                ArrayList<AbstractPiece> temp = new ArrayList<>(smallerPermutated);
                temp.add(index, firstAbstractPiecelement);
                if (isValidList(temp) && solve(temp)) {
                    Puzzle.printPuzzle(puzzle);
                    System.exit(0);
                } else {
                    returnValue.add(temp);
                }
            }
        }
        return returnValue;
    }

    //Since some permutations of a list can have with not enough pieces / duplicate pieces
    // I'm just checking to make sure its a valid list
    private static boolean isValidList(ArrayList<AbstractPiece> temp) {
        if (temp.size() != placedPieces.size()) {
            return false;
        } else {
            for (int j = 0; j < temp.size(); j++) {
                for (int k = j + 1; k < temp.size(); k++) {
                    if (k != j && temp.get(k) == temp.get(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private static boolean solve(List<AbstractPiece> pieces) {
        for (AbstractPiece piece : pieces) {
            boolean wasPlaced = placePiece(piece, piece.getMainBlock().getPosition());
            if (!wasPlaced) {
                placedPieces.clear();
                Puzzle.clearPuzzle(puzzle);
                return false;
            } else {
                updatePuzzle(puzzle, piece);
                placedPieces.add(piece);
            }
        }
        return true;
    }

    private static boolean placePiece(AbstractPiece piece, Position startPosition) {
        ArrayList<Position> positions = Puzzle.findOpenSpots(puzzle, startPosition);
        return pieceFits(piece, positions, puzzle, startPosition);
    }

    private static void updatePuzzle(Block[][] puzzle, AbstractPiece piece) {
        for (Block b : piece.getBlocks()) {
            int x = b.getXPosition();
            int y = b.getyPosition();

            puzzle[x][y] = b;
        }
    }

    private static boolean pieceFits(AbstractPiece piece, ArrayList<Position> positions, Block[][] puzzle, Position startPosition) {

        for (Position position : positions) {
            boolean x = checkPositionForPiece(piece, puzzle, position, startPosition);
            if (x == true) return x;
        }

        return false;
    }

    private static boolean checkPositionForPiece(AbstractPiece piece, Block[][] puzzle, Position newPosition, Position currentPosition) {
        if (newPosition.equals(currentPosition)) {
            return false;
        }

        piece.setStartLocation(newPosition);

        for (Position p : piece.getBlockPositions()) {
            int x = p.getX();
            int y = p.getY();

            if (x < 0 || x >= puzzle.length || y < 0 || y >= puzzle[x].length || puzzle[x][y] != null) {
                return false;
            }
        }
        return true;
    }

}
