public class Position {
    int row;
    int col;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Position)) return false;

        Position p = (Position) obj;
        return row==p.row && col==p.col;
    }

    @Override
    public int hashCode(){
        return row*31+col;
    }

}