import java.util.LinkedList;
import java.util.Queue;

public class EventQueue {

    private Queue<Event> queue;

    public EventQueue() {
        queue = new LinkedList<>();
    }

    public void addEvent(String eventType) {

        queue.add(new Event(eventType));
    }

    public void processEvents() {

        System.out.println("\n=== Event Queue ===");

        while(!queue.isEmpty()) {

            Event event = queue.poll();

            System.out.println("Processing: " + event);
        }
    }
}