package pieces;

public class GreenL extends AbstractPiece{
    private final static String name = "gl";

    public GreenL(){
        super(name,4);
        generatePiece();
    }

    private void generatePiece() {
        Block bm =  new Block(name,0,0);
        Block mm = new Block(name,1,0);
        Block tm = new Block(name,2,0);
        Block tr = new Block(name,2,1);

        bm.position = new Position(0,-1);
        setMainBlock(bm);

        bm.addObserver(mm);
        bm.addObserver(tm);
        bm.addObserver(tr);


        addBlock(bm);
        addBlock(tr);
        addBlock(tm);
        addBlock(mm);
    }

}
