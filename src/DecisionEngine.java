import java.util.*;
public class DecisionEngine {

    private PriorityQueue<Action> actions;

    public DecisionEngine() {
        actions = new PriorityQueue<>();
    }

    public Action decide(Grid grid) {

        actions.clear();

        Random random = new Random();

        actions.add(new Action("Move To Target", 100));

        actions.add(new Action("Explore",random.nextInt(50)));

        actions.add(new Action("Wait",10));

        System.out.println("\nAvailable Actions:");

        for (Action a : actions) {
            System.out.println(a);
        }

        Action bestAction = actions.poll();

        System.out.println("\nChosen Action: " + bestAction.getName());

        return bestAction;
    }
}