import java.util.*;

public class BFSPathFinder {

    static int[] ROW = {-1,1,0,0};
    static int[] COL = {0,0,-1,1};


    public static List<Position> findPath(Grid grid){

        Position start = grid.getAgentPos();
        Position target = grid.getTargetPos();

        int size = grid.getSize();

        boolean[][] visited = new boolean[size][size];

        Queue<Position> queue = new LinkedList<>();
        Map<Position,Position> map = new HashMap<>();

        queue.add(start);
        visited[start.row][start.col] = true;

        while (!queue.isEmpty()){

            Position current = queue.poll();

            if (current.equals(target)) break;

            for (int i=0; i<4; i++){

                int nr = current.row+ROW[i];
                int nc = current.col+COL[i];

                if (nr<0 || nc<0 || nr>=size || nc>=size) continue;

                if (visited[nr][nc]) continue;

                if (grid.getGrid()[nr][nc]==Cell.OBSTACLE) continue;

                Position next = new Position(nr,nc);

                queue.add(next);

                visited[nr][nc] = true;

                map.put(next,current);
            }
        }

        List<Position> path = new ArrayList<>();

        Position current = target;

        while (current != null){
            path.add(current);
            current = map.get(current);
        }

        Collections.reverse(path);

        if (!path.get(0).equals(start)) return new ArrayList<>();

        return path;
    }

}