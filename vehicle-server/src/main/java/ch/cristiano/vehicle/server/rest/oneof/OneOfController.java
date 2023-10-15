package ch.cristiano.vehicle.server.rest.oneof;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.openapitools.oneof.api.VehiclesApi;
import org.openapitools.oneof.model.CarData;
import org.openapitools.oneof.model.CicleData;
import org.openapitools.oneof.model.PaginationInfo;
import org.openapitools.oneof.model.TruckData;
import org.openapitools.oneof.model.Vehicle;
import org.openapitools.oneof.model.VehicleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.cristiano.vehicle.server.persistence.CarEntity;
import ch.cristiano.vehicle.server.persistence.CarRepository;
import ch.cristiano.vehicle.server.persistence.CicleEntity;
import ch.cristiano.vehicle.server.persistence.TruckEntity;
import ch.cristiano.vehicle.server.persistence.VehicleEntity;
import ch.cristiano.vehicle.server.persistence.VehicleRepository;

@RestController
public class OneOfController implements VehiclesApi {

    private final VehicleRepository vehicleRepository;
    private final CarRepository carRepository;

    public OneOfController(VehicleRepository repository, CarRepository carRepository) {
        this.vehicleRepository = repository;
        this.carRepository = carRepository;
    }

    @Override
    public ResponseEntity<VehicleResponse> queryVehicles(@Valid Integer page, @Min(1) @Max(100) @Valid Integer size) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<VehicleEntity> entities = vehicleRepository.findAll(pageRequest);
        List<Vehicle> vehicles = this.getVehicles(entities.getContent());
        vehicleResponse.setVehicles(vehicles);
        vehicleResponse.setPaginationInfo(this.getPaginationInfo(entities));
        return ResponseEntity.ok(vehicleResponse);
    }

    @RequestMapping("/vehicles/pagination")
    @GetMapping
    public Page<VehicleEntity> query(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "20") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<VehicleEntity> vehicleEntities = vehicleRepository.findAll(pageRequest);
        return vehicleEntities;
    }

    @RequestMapping("/cars")
    @GetMapping
    public Page<CarEntity> queryCars(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "20") int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("color"));
        return carRepository.findAll(pageRequest);
    }

    private List<Vehicle> getVehicles(List<VehicleEntity> entities) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (VehicleEntity vehicleEntity : entities) {
            switch (vehicleEntity.getVehicleType()) {
                case "CAR":
                    CarEntity carEntity = (CarEntity) vehicleEntity;
                    vehicles.add(this.mapToCar(carEntity));
                    break;
                case "TRUCK":
                    TruckEntity truckEntity = (TruckEntity) vehicleEntity;
                    vehicles.add(this.mapToTruck(truckEntity));
                    break;
                case "CICLE":
                    CicleEntity cicleEntity = (CicleEntity) vehicleEntity;
                    vehicles.add(this.mapToCicle(cicleEntity));
                    break;
            }
        }
        return vehicles;
    }

    private Vehicle mapToCar(CarEntity carEntity) {
        Vehicle car = new Vehicle(carEntity.getVehicleType());
        car.setColor(carEntity.getColor());
        CarData carData = new CarData(carEntity.getVehicleType());
        carData.setCarAttributes(carEntity.getCarAttributes());
        car.setData(carData);
        return car;
    }

    private Vehicle mapToTruck(TruckEntity truckEntity) {
        Vehicle truck = new Vehicle(truckEntity.getVehicleType());
        truck.setColor(truckEntity.getColor());
        TruckData truckData = new TruckData(truckEntity.getVehicleType());
        truckData.setTruckAttributes(truckEntity.getTruckAttributes());
        truckData.setTruckCountWheels(truckEntity.getCountWheels());
        truck.setData(truckData);
        return truck;
    }

    private Vehicle mapToCicle(CicleEntity cicleEntity) {
        Vehicle cicle = new Vehicle(cicleEntity.getVehicleType());
        cicle.setColor(cicleEntity.getColor());
        CicleData cicleData = new CicleData(cicleEntity.getVehicleType());
        cicleData.setCicleAttributes(cicleEntity.getCicleAttributes());
        cicleData.setCicleCountWheels(2);
        cicle.setData(cicleData);
        return cicle;
    }

    private PaginationInfo getPaginationInfo(Page<VehicleEntity> page) {
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setPage(page.getNumber());
        paginationInfo.setSize(page.getSize());
        paginationInfo.setNumberOfElements(page.getNumberOfElements());
        paginationInfo.setTotalElements(page.getTotalElements());
        paginationInfo.setTotalPages(page.getTotalPages());
        return paginationInfo;
    }
}
