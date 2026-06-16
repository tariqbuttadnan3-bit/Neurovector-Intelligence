import java.util.HashMap;

public class Statistics {

    private HashMap<String,Integer> stats;

    public Statistics() {

        stats = new HashMap<>();

        stats.put("Moves",0);
        stats.put("DangerHits",0);
        stats.put("TargetsReached",0);
    }

    public void increment(String key) {

        stats.put(key, stats.get(key)+1);
    }

    public void printStats() {

        System.out.println("\n=== Statistics ===");

        for(String key : stats.keySet()) {

            System.out.println(key + " : " + stats.get(key));
        }
    }
}