package pieces;

public class Cross extends AbstractPiece{
    private final static String name = "cr";

    public Cross(){
        super(name, 5);
        generatePiece();
    }

    private void generatePiece() {
        Block center =  new Block(name,0,0);
        Block up = new Block(name,1,0);
        Block right = new Block(name,0,1);
        Block left = new Block(name,0,-1);
        Block down = new Block(name,-1,0);

        center.position = new Position(0,-1);

        center.addObserver(up);
        center.addObserver(right);
        center.addObserver(left);
        center.addObserver(down);

        addBlock(center);
        addBlock(down);
        addBlock(left);
        addBlock(right);
        addBlock(up);

        setMainBlock(center);
    }
}
