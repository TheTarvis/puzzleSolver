package pieces;

public class Line extends AbstractPiece{
    private final static String name = "ln";

    public Line(){
        super(name,5);
        generatePiece();
    }

    private void generatePiece() {
        Block start =  new Block(name,0,0);
        Block block4 = new Block(name,4,0);
        Block block3 = new Block(name,3,0);
        Block block2 = new Block(name,2,0);
        Block block1 = new Block(name,1,0);

        start.position = new Position(0,-1);

        start.addObserver(block4);
        start.addObserver(block3);
        start.addObserver(block2);
        start.addObserver(block1);

        addBlock(start);
        addBlock(block1);
        addBlock(block2);
        addBlock(block3);
        addBlock(block4);

        setMainBlock(start);
    }
}
