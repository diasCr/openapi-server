package ch.swisscard.demo.server.rest;

import java.util.ArrayList;
import java.util.List;

import org.openapitools.api.VehiclesApi;
import org.openapitools.model.CarData;
import org.openapitools.model.CicleData;
import org.openapitools.model.TruckData;
import org.openapitools.model.Vehicle;
import org.openapitools.model.VehicleColor;
import org.openapitools.model.VehicleType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController implements VehiclesApi {

    @Override
    public ResponseEntity<List<Vehicle>> queryVehicles() {
        List<Vehicle> vehicles = this.getVehicles();
        return ResponseEntity.ok(vehicles);
    }

    private List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle car = new Vehicle(VehicleType.CAR.name());
        car.setColor(VehicleColor.RED.name());
        CarData carData = new CarData(VehicleType.CAR.name());
        carData.setCarAttributes("car attributes");
        car.setData(carData);

        Vehicle truck = new Vehicle(VehicleType.TRUCK.name());
        truck.setColor(VehicleColor.GREEN.name());
        TruckData truckData = new TruckData(VehicleType.TRUCK.name());
        truckData.setTruckAttributes("truck attributes");
        truckData.setTruckCountWheels(8);
        truck.setData(truckData);

        Vehicle cicle = new Vehicle(VehicleType.CICLE.name());
        cicle.setColor(VehicleColor.BLUE.name());
        CicleData cicleData = new CicleData(VehicleType.CICLE.name());
        cicleData.setCicleAttributes("cicle attributes");
        cicleData.setCicleCountWheels(2);
        cicle.setData(cicleData);

        vehicles.add(car);
        vehicles.add(truck);
        // vehicles.add(cicle);

        return vehicles;
    }
}
