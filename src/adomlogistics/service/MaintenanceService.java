package adomlogistics.service;

import adomlogistics.model.Delivery;
import adomlogistics.model.Vehicle;
import adomlogistics.utils.BasicHashMap;
import adomlogistics.utils.DeliveryQueue;
import adomlogistics.model.maintenanceRecord;

public class MaintenanceService {
    private DeliveryQueue maintenanceQueue;
    private BasicHashMap<String, Vehicle> vehicleMap;
    private BasicHashMap<String, maintenanceRecord[]> maintenanceHistory;

    public MaintenanceService() {
        maintenanceQueue = new DeliveryQueue(100);
        vehicleMap = new BasicHashMap<>();
        maintenanceHistory = new BasicHashMap<>();
    }

    public void scheduleMaintenance(Vehicle vehicle) {
        if (!vehicleMap.containsKey(vehicle.regNumber)) {
            vehicleMap.put(vehicle.regNumber, vehicle);
            maintenanceQueue.enqueue(new Delivery(vehicle.regNumber, "", "", calculateUrgency(vehicle)));
        }
    }

    public Vehicle[] getMaintenanceQueue() {
        Delivery[] deliveries = maintenanceQueue.getAllDeliveries();
        Vehicle[] vehicles = new Vehicle[deliveries.length];
        for (int i = 0; i < deliveries.length; i++) {
            vehicles[i] = vehicleMap.get(deliveries[i].packageId);
        }
        return vehicles;
    }

    public Vehicle getNextMaintenance() {
        Delivery next = maintenanceQueue.peek();
        return next != null ? vehicleMap.get(next.packageId) : null;
    }

    public int calculateUrgency(Vehicle vehicle) {
        int daysSinceService = 30; // Simplified calculation
        return vehicle.mileage / 10000 + daysSinceService / 30;
    }

    public void addMaintenanceRecord(String regNumber, maintenanceRecord record) {
        maintenanceRecord[] current = maintenanceHistory.get(regNumber);
        maintenanceRecord[] updated = new maintenanceRecord[current != null ? current.length + 1 : 1];
        if (current != null) {
            System.arraycopy(current, 0, updated, 0, current.length);
        }
        updated[updated.length - 1] = record;
        maintenanceHistory.put(regNumber, updated);
    }

    public maintenanceRecord[] getMaintenanceHistory(String regNumber) {
        return maintenanceHistory.get(regNumber);
    }
}