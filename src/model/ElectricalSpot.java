package model;

public class ElectricalSpot extends Spot{
    public ElectricalSpot(String id) {
        super(id, ParkingSpotType.ELECTRIC);
    }
}
