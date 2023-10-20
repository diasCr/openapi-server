package ch.cristiano.vehicle.server.persistence;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "CAR")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CarEntity extends VehicleEntity {

    private String carAttributes;

    protected CarEntity() {
    }

    public CarEntity(String vehicleType, String color, String carAttributes) {
        super(vehicleType, color);
        this.carAttributes = carAttributes;
    }

    public String getCarAttributes() {
        return carAttributes;
    }

    @Override
    public String toString() {
        return "CarEntity [carAttributes=" + carAttributes + "]";
    }

}
