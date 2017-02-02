package pieces;

public class BlueL extends AbstractPiece{
    private final static String name = "bl";

    public BlueL(){
        super(name, 4);
        generatePiece();
    }

    private void generatePiece() {
        Block bm =  new Block(name,0,0);
        Block mm = new Block(name,1,0);
        Block mt = new Block(name,2,0);
        Block tl = new Block(name,2,-1);

        bm.position = new Position(0,-1);

        bm.addObserver(mm);
        bm.addObserver(mt);
        bm.addObserver(tl);

        addBlock(bm);
        addBlock(mm);
        addBlock(mt);
        addBlock(tl);

        setMainBlock(bm);
    }
}
