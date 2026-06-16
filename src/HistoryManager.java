import java.util.Stack;

public class HistoryManager {

    private Stack<Move> history;

    public HistoryManager() {
        history = new Stack<>();
    }

    public void recordMove(int row, int col) {
        history.push(new Move(row, col));
    }

    public void replayHistory() {
        if(history.isEmpty()) {
            System.out.println("\nNo History Available!");
            return;
        }

        System.out.println("\n=== Replay History ===");

        Stack<Move> temp = (Stack<Move>) history.clone();

        while(!temp.isEmpty()) {
            System.out.println(temp.pop());
        }
    }

    public Move undoLastMove() {
        if(history.isEmpty()) {
            return null;
        }
        return history.pop();
    }
}