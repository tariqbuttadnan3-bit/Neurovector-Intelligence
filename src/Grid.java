import java.util.*;

public class Grid {

    private final int size = 20;
    private char[][] grid;
    private Position agentPos;
    private Position targetPos;
    private List<Position> shortestPath = new ArrayList<>();

    public Grid(){
        grid = new char[size][size];
        generateGrid();
    }

    public void generateGrid(){
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                grid[i][j] = Cell.EMPTY;
            }
        }

        Random random = new Random();

        for (int i=0; i<60; i++){
            int r = random.nextInt(size);
            int c = random.nextInt(size);
            grid[r][c] = Cell.OBSTACLE;
        }

        for (int i=0; i<25; i++){
            int r = random.nextInt(size);
            int c = random.nextInt(size);
            if (grid[r][c]==Cell.EMPTY){
                grid[r][c] = Cell.DANGER;
            }
        }

        while (true){
            int r = random.nextInt(size);
            int c = random.nextInt(size);
            if (grid[r][c]==Cell.EMPTY){
                agentPos = new Position(r,c);
                grid[r][c] = Cell.AGENT;
                break;
            }
        }

        while (true){
            int r = random.nextInt(size);
            int c = random.nextInt(size);
            if (grid[r][c]==Cell.EMPTY){
                targetPos = new Position(r,c);
                grid[r][c] = Cell.TARGET;
                break;
            }
        }
    }

    public char[][] getGrid(){
        return grid;
    }

    public int getSize(){
        return size;
    }

    public Position getAgentPos(){
        return agentPos;
    }

    public Position getTargetPos(){
        return targetPos;
    }

    public void setShortestPath(List<Position> path){
        shortestPath = path;
    }

    public List<Position> getShortestPath(){
        return shortestPath;
    }
}