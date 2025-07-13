package adomlogistics.model;

public class Vehicle {
    public String regNumber;
    public String name;
    public String type; // "Truck" or "Van"
    public float fuelUsage;
    public int mileage;
    public Integer driverId;
    public String maintenanceHistory;
    public String lastServiceDate;

    public Vehicle(String regNumber, String name, String type,
                   float fuelUsage, int mileage, Integer driverId,
                   String maintenanceHistory, String lastServiceDate) {
        this.regNumber = regNumber;
        this.name = name;
        this.type = type;
        this.fuelUsage = fuelUsage;
        this.mileage = mileage;
        this.driverId = driverId;
        this.maintenanceHistory = maintenanceHistory;
        this.lastServiceDate = lastServiceDate;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %.1fL | %dkm | %s | Last Service: %s",
                regNumber, name, type, fuelUsage, mileage,
                (driverId != null) ? "Driver "+driverId : "Unassigned",
                lastServiceDate);
    }
}//Adom-logistics-drivers