package pieces;

public class Position{
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean hasNoMoreSpots() {
        return noMoreSpots;
    }

    public void setNoMoreSpots(boolean noMoreSpots) {
        this.noMoreSpots = noMoreSpots;
    }

    int x = -1;
    int y = -1;
    boolean noMoreSpots = false;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position(){
        this.x = 0;
        this.y = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        if (y != position.y) return false;
        return noMoreSpots == position.noMoreSpots;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (noMoreSpots ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", noMoreSpots=" + noMoreSpots +
                '}';
    }
}
