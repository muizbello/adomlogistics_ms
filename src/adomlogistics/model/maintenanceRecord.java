package adomlogistics.model;

public class maintenanceRecord {
    public String recordId;
    public String vehicleId;
    public String serviceType;
    public int mileage;
    public String serviceDate;
    public int urgencyScore;

    public maintenanceRecord(String recordId, String vehicleId,
                             String serviceType, int mileage,
                             String serviceDate, int urgencyScore) {
        this.recordId = recordId;
        this.vehicleId = vehicleId;
        this.serviceType = serviceType;
        this.mileage = mileage;
        this.serviceDate = serviceDate;
        this.urgencyScore = urgencyScore;
    }
}