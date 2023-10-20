package ch.cristiano.vehicle.server.persistence;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FERRARI")
public class FerrariEntity extends CarEntity {

    private String test2;

    public FerrariEntity() {
    }

    public FerrariEntity(String vehicleType, String color, String carAttributes, String test2) {
        super(vehicleType, color, carAttributes);
        this.test2 = test2;
    }

    public String getTest2() {
        return test2;
    }

    @Override
    public String toString() {
        return "FerrariEntity [test2=" + test2 + "]";
    }

}
