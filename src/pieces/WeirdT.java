package pieces;

public class WeirdT extends AbstractPiece{
    private final static String name = "wt";

    public WeirdT(){
        super(name, 5);

        Block fl =  new Block(name,0,0);
        Block inl = new Block(name,0,1);
        Block inr = new Block(name,0,2);
        Block fr = new Block(name,0,3);
        Block dm = new Block(name,-1,1);

        fl.position = new Position(0,-1);

        fl.addObserver(inl);
        fl.addObserver(inr);
        fl.addObserver(fr);
        fl.addObserver(dm);


        addBlock(fl);
        addBlock(fr);
        addBlock(inr);
        addBlock(inl);
        addBlock(dm);

        setMainBlock(fl);
    }

}
