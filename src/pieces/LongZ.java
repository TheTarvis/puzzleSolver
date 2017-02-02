package pieces;

public class LongZ extends AbstractPiece{
    private final static String name = "lz";
    Block startBlock;

    public LongZ(){
        super(name,5);
        generatePiece();
    }

    private void generatePiece() {
        Block tl =  new Block(name,0,0);
        Block tm = new Block(name,0,1);
        Block bm = new Block(name,-1,1);
        Block bmm = new Block(name,-1,2);
        Block br = new Block(name,-1,3);

        tl.position = new Position(0,-1);

        tl.addObserver(tm);
        tl.addObserver(bm);
        tl.addObserver(bmm);
        tl.addObserver(br);

        addBlock(tl);
        addBlock(bmm);
        addBlock(bm);
        addBlock(tm);
        addBlock(br);

        setMainBlock(tl);
    }
}
