package pieces;

public class Stair extends AbstractPiece{
    private final static String name = "st";

    public Stair(){
        super(name, 5);
        generatePiece();
    }

    private void generatePiece() {
        Block tl =  new Block(name,0,0);
        Block ml = new Block(name,-1,0);
        Block mm = new Block(name,-1,1);
        Block bm = new Block(name,-2,1);
        Block br = new Block(name,-2,2);

        tl.position = new Position(0,-1);

        tl.addObserver(ml);
        tl.addObserver(mm);
        tl.addObserver(bm);
        tl.addObserver(br);

        addBlock(tl);
        addBlock(br);
        addBlock(bm);
        addBlock(mm);
        addBlock(ml);

        setMainBlock(tl);
    }
}
