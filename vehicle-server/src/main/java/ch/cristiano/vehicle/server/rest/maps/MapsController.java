package ch.cristiano.vehicle.server.rest.maps;

import java.util.ArrayList;
import java.util.List;

import org.openapitools.maps.api.VehiclesApi;
import org.openapitools.maps.model.CarDataMap;
import org.openapitools.maps.model.CicleDataMap;
import org.openapitools.maps.model.TruckDataMap;
import org.openapitools.maps.model.Vehicle;
import org.openapitools.maps.model.VehicleColor;
import org.openapitools.maps.model.VehicleType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapsController implements VehiclesApi {

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
        TruckDataMap truckAdditionalData = new TruckDataWrapper("truck attributes", 8);
        truck.setData(truckAdditionalData.getAdditionalProperties());

        Vehicle cicle = new Vehicle(VehicleType.CICLE.name());
        cicle.setColor(VehicleColor.GREEN.name());
        CicleDataMap cicleAdditionalData = new CicleDataWrapper("cicle attributes", 2);
        cicle.setData(cicleAdditionalData.getAdditionalProperties());

        vehicles.add(car);
        vehicles.add(truck);
        // vehicles.add(cicle);

        return vehicles;
    }
}
