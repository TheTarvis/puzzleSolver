package pieces;

public class WeirdF extends AbstractPiece{
    private final static String name = "wf";

    public WeirdF(){
        super(name, 5);
        generatePiece();
    }

    private void generatePiece() {
        Block ml =  new Block(name,0,0);
        Block mm = new Block(name,0,1);
        Block mr = new Block(name,0,2);
        Block top = new Block(name,1,1);
        Block bottom = new Block(name,-1,2);

        ml.position = new Position(0,-1);

        ml.addObserver(mm);
        ml.addObserver(mr);
        ml.addObserver(top);
        ml.addObserver(bottom);

        addBlock(ml);
        addBlock(top);
        addBlock(mr);
        addBlock(mm);
        addBlock(bottom);

        setMainBlock(ml);
    }

}
