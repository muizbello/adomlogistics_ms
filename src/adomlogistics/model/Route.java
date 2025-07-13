package adomlogistics.model;

public class Route {
    public int id;
    public String origin;
    public String destination;
    public String date;
    public int estimatedTime; // in minutes
    public String status; // "Pending", "In Progress", "Completed"

    public Route(int id, String origin, String destination,
                 String date, int estimatedTime) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.estimatedTime = estimatedTime;
        this.status = "Pending";
    }

    @Override
    public String toString() {
        return String.format("Route %d: %s to %s | %s | %d mins | %s",
                id, origin, destination, date, estimatedTime, status);
    }
}