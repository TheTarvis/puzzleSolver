package pieces;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPiece{
    private final int numBlocks;
    String name;
    ArrayList<Block> blocks;
    Block mainBlock;
    public AbstractPiece(String name, int numBlocks){
        this.name = name;
        this.numBlocks = numBlocks;
        blocks = new ArrayList<>(numBlocks);
    }

    public void setMainBlock(Block mainBlock) {
        this.mainBlock = mainBlock;
    }

    public Block getMainBlock(){
        return mainBlock;
    }

    public void addBlock(Block b){
        blocks.add(b);
    }

    public String getName(){
        return name;
    }

    public void setStartLocation(Position startLocation) {
        mainBlock.reposition(startLocation);
    }

    public List<Position> getBlockPositions(){
        ArrayList positions = new ArrayList<>(numBlocks);
        for(Block b: blocks){
            positions.add(b.getPosition());
        }
        return positions;
    }

    public List<Block> getBlocks(){
        return blocks;
    }

    @Override
    public String toString() {
        return name + ":" + numBlocks + ", ";
    }
}
