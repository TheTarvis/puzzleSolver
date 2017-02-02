package pieces;

public class OneByOne extends AbstractPiece{
    private final static String name = "11";

    public OneByOne(){
        super(name,1);
        generatePiece();
    }

    private void generatePiece() {
        Block block0 =  new Block(name,0,0);
        block0.position = new Position(0,-1);
        addBlock(block0);
        setMainBlock(block0);
    }
}
