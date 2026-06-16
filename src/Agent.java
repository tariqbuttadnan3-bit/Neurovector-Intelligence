import java.util.List;
public class Agent {

    private DecisionEngine engine;
    private HistoryManager history;
    private EventQueue eventQueue;
    private Statistics statistics;

    public Agent() {
        engine = new DecisionEngine();
        history = new HistoryManager();
        eventQueue = new EventQueue();
        statistics = new Statistics();
    }

    public void navigate(Grid grid) {

        Action action = engine.decide(grid);

        if(!action.getName().equals("Move To Target")) {
            System.out.println("\nAgent decided not to move.");
            return;
        }

        List<Position> path = BFSPathFinder.findPath(grid);

        grid.setShortestPath(path);

        if(path.isEmpty()) {
            System.out.println("\nNo Path Found!");
            return;
        }

        System.out.println("\nShortest Path:");

        for(int i = 1; i < path.size(); i++){
            Position p = path.get(i);
            System.out.println("(" + p.row + "," + p.col + ")");

            history.recordMove(p.row, p.col);

            eventQueue.addEvent("MOVE");

            statistics.increment("Moves");

            if(grid.getGrid()[p.row][p.col] == Cell.DANGER) {

                eventQueue.addEvent("DANGER_ENCOUNTER");

                statistics.increment("DangerHits");
            }
        }

        eventQueue.addEvent("TARGET_REACHED");

        statistics.increment("TargetsReached");

        System.out.println("\nPath Length: " + (path.size() - 1));

        history.replayHistory();

        eventQueue.processEvents();

        statistics.printStats();
    }
}