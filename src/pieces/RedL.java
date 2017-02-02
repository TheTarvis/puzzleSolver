package pieces;

public class RedL extends AbstractPiece{
    private final static String name = "rl";

    public RedL(){
        super(name,4);
        generatePiece();
    }

    private void generatePiece() {
        Block bl =  new Block(name,0,0);
        Block bm = new Block(name,0,1);
        Block rm = new Block(name,0,2);
        Block rt = new Block(name,1,2);

        bl.position = new Position(0,-1);

        bl.addObserver(bm);
        bl.addObserver(rm);
        bl.addObserver(rt);

        addBlock(bl);
        addBlock(rt);
        addBlock(rm);
        addBlock(bm);

        setMainBlock(bl);
    }
}
