package adomlogistics.model;

public class Delivery {
    public String packageId;
    public String origin;
    public String destination;
    public String assignedVehicleId;
    public Integer assignedDriverId;
    public int estimatedHours;
    public String status; // "Pending", "In Transit", "Delivered", "Delayed"
    public String createdAt;

    public Delivery(String packageId, String origin, String destination, int estimatedHours) {
        this.packageId = packageId;
        this.origin = origin;
        this.destination = destination;
        this.estimatedHours = estimatedHours;
        this.status = "Pending";
        this.createdAt = String.valueOf(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return String.format("%s: %s to %s | %s | Vehicle: %s | Driver: %s",
                packageId, origin, destination, status,
                assignedVehicleId != null ? assignedVehicleId : "Unassigned",
                assignedDriverId != null ? assignedDriverId : "Unassigned");
    }
}