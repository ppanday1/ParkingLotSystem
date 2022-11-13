package model;

public class Spot {
    private String number;
    private boolean free;
    private Vehicle vehicle;
    private final ParkingSpotType type;

    public Spot(String number, ParkingSpotType type) {
        this.number = number;
        this.type = type;
    }

    public boolean IsFree(){
     return free;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        if(this.vehicle!=null)
            return false;
        this.vehicle = vehicle;
        free = false;
        return true;
    }

    public boolean removeVehicle() {
        if(vehicle==null)
            return false;
        this.vehicle = null;
        free = true;
        return true;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpotType getType() {
        return type;
    }
}
