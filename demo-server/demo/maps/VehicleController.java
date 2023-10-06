package ch.swisscard.demo.server.rest;

import java.util.ArrayList;
import java.util.List;

import org.openapitools.api.VehiclesApi;
import org.openapitools.model.CarDataMap;
import org.openapitools.model.CicleDataMap;
import org.openapitools.model.TruckDataMap;
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
        CarDataMap carAdditionalData = new CarDataWrapper("car attributes");
        car.setData(carAdditionalData.getAdditionalProperties());

        Vehicle truck = new Vehicle(VehicleType.TRUCK.name());
        truck.setColor(VehicleColor.BLUE.name());
        TruckDataMap truckAdditionalData = new TruckDataWrapper("truck attributes", "8");
        truck.setData(truckAdditionalData.getAdditionalProperties());

        Vehicle cicle = new Vehicle(VehicleType.CICLE.name());
        cicle.setColor(VehicleColor.GREEN.name());
        CicleDataMap cicleAdditionalData = new CicleDataWrapper("cicle attributes", "2");
        cicle.setData(cicleAdditionalData.getAdditionalProperties());

        vehicles.add(car);
        vehicles.add(truck);
        // vehicles.add(cicle);

        return vehicles;
    }
}
