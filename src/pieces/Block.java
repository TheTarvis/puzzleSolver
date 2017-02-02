package pieces;

import java.util.Observable;
import java.util.Observer;

public class Block extends Observable implements Observer {
    private final String name;
    Position position;
    int xFromCenter;
    int yFromCenter;

    public Block(String name,int xFromCenter, int yFromCenter){
        this.name = name;
        position = new Position(xFromCenter,yFromCenter);
        this.xFromCenter = xFromCenter;
        this.yFromCenter = yFromCenter;
    }


    public int getXPosition() {
        return position.getX();
    }

    public int getyPosition() {
        return position.getY();
    }

    public String getName(){
        return name;
    }

    public void reposition(Position startLocation) {
        this.position = startLocation;
        setChanged();
        notifyObservers();
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public void update(Observable o, Object arg) {
        Block b = (Block)o;

        this.getPosition().setX(xFromCenter + b.getPosition().getX());
        this.getPosition().setY(yFromCenter + b.getPosition().getY());
    }

    @Override
    public String toString() {
        return "Block{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
