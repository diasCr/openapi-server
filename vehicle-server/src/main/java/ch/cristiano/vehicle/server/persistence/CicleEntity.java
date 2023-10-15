package ch.cristiano.vehicle.server.persistence;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CICLE")
public class CicleEntity extends VehicleEntity {

    private String cicleAttributes;
    private boolean electric;

    protected CicleEntity() {

    }

    public CicleEntity(String vehicleType, String color, String cicleAttributes, boolean electric) {
        super(vehicleType, color);
        this.cicleAttributes = cicleAttributes;
        this.electric = electric;
    }

    public String getCicleAttributes() {
        return cicleAttributes;
    }

    public boolean isElectric() {
        return electric;
    }

    @Override
    public String toString() {
        return "CicleEntity [cicleAttributes=" + cicleAttributes + ", electric=" + electric + "]";
    }

}
