package pieces;

public class UpsideDownT extends AbstractPiece{
    private final static String name = "ut";

    public UpsideDownT(){
        super(name,5);
        generatePiece();
    }

    private void generatePiece() {
        Block tm = new Block(name,2,0); //top middle
        Block mm = new Block(name,1,0); //middle middle
        Block br = new Block(name,0,1); //bottom right
        Block bm = new Block(name,0,0); // bottom middle
        Block bl =  new Block(name,0,-1); //bottom left

        tm.position = new Position(0,-1);

        bm.addObserver(tm);
        bm.addObserver(mm);
        bm.addObserver(br);
        bm.addObserver(bl);

        addBlock(bm);
        addBlock(bl);
        addBlock(br);
        addBlock(mm);
        addBlock(tm);

        setMainBlock(bm);
    }
}
