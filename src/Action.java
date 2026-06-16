public class Action implements Comparable<Action> {

    private String name;
    private int priority;

    public Action(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Action other) {
        return Integer.compare(other.priority,this.priority);
    }

    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}