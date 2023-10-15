package ch.cristiano.vehicle.server.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String vehicleType;
    private String color;

    protected VehicleEntity() {
    }

    public VehicleEntity(String vehicleType, String color) {
        this.vehicleType = vehicleType;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "VehicleEntity [id=" + id + ", vehicleType=" + vehicleType + ", color=" + color + "]";
    }
}