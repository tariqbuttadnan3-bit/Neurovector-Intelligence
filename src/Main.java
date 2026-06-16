public class Main {

    public static void main(String[] args) {

        Grid grid = new Grid();

        Agent agent = new Agent();

        agent.navigate(grid);

        new GridFrame(grid);
    }
}