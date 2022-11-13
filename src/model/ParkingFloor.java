package model;

import java.util.HashMap;

public class ParkingFloor {
    private String name;
    private HashMap<String, Spot> handicappedSpots;
    private HashMap<String, Spot> compactSpots;
    private HashMap<String, Spot> largeSpots;
    private HashMap<String, Spot> motorbikeSpots;
    private HashMap<String, Spot> electricSpots;
    private HashMap<String, CustomerPortalInfo> infoPortals;
    private ParkingDisplayBoard displayBoard;

    public ParkingFloor(String name) {
        this.name = name;
    }

    public void addParkingSpot(Spot spot) {
        switch (spot.getType()) {
            case HANDICAPPED:
                handicappedSpots.put(spot.getNumber(), spot);
                break;
            case COMPACT:
                compactSpots.put(spot.getNumber(), spot);
                break;
            case LARGE:
                largeSpots.put(spot.getNumber(), spot);
                break;
            case MOTORBIKE:
                motorbikeSpots.put(spot.getNumber(), spot);
                break;
            case ELECTRIC:
                electricSpots.put(spot.getNumber(), spot);
                break;
            default:
                System.out.println("Wrong parking spot type!");
        }
    }

    public void assignVehicleToSpot(Vehicle vehicle, Spot spot) {
        spot.assignVehicle(vehicle);
        switch (spot.getType()) {
            case ParkingSpotType.HANDICAPPED:
                updateDisplayBoardForHandicapped(spot);
                break;
            case ParkingSpotType.COMPACT:
                updateDisplayBoardForCompact(spot);
                break;
            case ParkingSpotType.LARGE:
                updateDisplayBoardForLarge(spot);
                break;
            case ParkingSpotType.MOTORBIKE:
                updateDisplayBoardForMotorbike(spot);
                break;
            case ParkingSpotType.ELECTRIC:
                updateDisplayBoardForElectric(spot);
                break;
            default:
                print("Wrong parking spot type!");
        }
    }

    private void updateDisplayBoardForHandicapped(ParkingSpot spot) {
        if (this.displayBoard.getHandicappedFreeSpot().getNumber() == spot.getNumber()) {
            // find another free handicapped parking and assign to displayBoard
            for (String key : handicappedSpots.keySet()) {
                if (handicappedSpots.get(key).isFree()) {
                    this.displayBoard.setHandicappedFreeSpot(handicappedSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    private void updateDisplayBoardForCompact(ParkingSpot spot) {
        if (this.displayBoard.getCompactFreeSpot().getNumber() == spot.getNumber()) {
            // find another free compact parking and assign to displayBoard
            for (String key : compactSpots.keySet()) {
                if (compactSpots.get(key).isFree()) {
                    this.displayBoard.setCompactFreeSpot(compactSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    public void freeSpot(Spot spot) {
        spot.removeVehicle();
        switch (spot.getType()) {
            case ParkingSpotType.HANDICAPPED:
                this.displayBoard.handicappedFreeSpot++;
                break;
            case ParkingSpotType.COMPACT:
                freeCompactSpotCount++;
                break;
            case ParkingSpotType.LARGE:
                freeLargeSpotCount++;
                break;
            case ParkingSpotType.MOTORBIKE:
                freeMotorbikeSpotCount++;
                break;
            case ParkingSpotType.ELECTRIC:
                freeElectricSpotCount++;
                break;
            default:
                print("Wrong parking spot type!");
        }
    }
}
