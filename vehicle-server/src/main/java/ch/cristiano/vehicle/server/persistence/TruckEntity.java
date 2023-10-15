package ch.cristiano.vehicle.server.persistence;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TRUCK")
public class TruckEntity extends VehicleEntity {

    private String truckAttributes;
    private int countWheels;

    protected TruckEntity() {

    }

    public TruckEntity(String vehicleType, String color, String truckAttributes, int countWheels) {
        super(vehicleType, color);
        this.truckAttributes = truckAttributes;
        this.countWheels = countWheels;
    }

    public String getTruckAttributes() {
        return truckAttributes;
    }

    public int getCountWheels() {
        return countWheels;
    }

    @Override
    public String toString() {
        return "TruckEntity [truckAttributes=" + truckAttributes + ", wheels=" + countWheels + "]";
    }

}
