package ch.cristiano.vehicle.server.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "BMW")
public class BmwEntity extends CarEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bmwId;
    private String test;

    public BmwEntity() {
    }

    public BmwEntity(String vehicleType, String color, String carAttributes, String test) {
        super(vehicleType, color, carAttributes);
        this.test = test;
    }

    public String getTest() {
        return test;
    }

    public Long getBmwId() {
        return bmwId;
    }

    @Override
    public String toString() {
        return "BmwEntity [bmwId=" + bmwId + ", test=" + test + "]";
    }

}
