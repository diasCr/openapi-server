package ch.cristiano.vehicle.server.rest.maps;

import org.openapitools.maps.model.CarDataMap;

public class CarDataWrapper extends CarDataMap {

    public CarDataWrapper(String carAttributes) {
        super(carAttributes);
        super.putAdditionalProperty("carAttributes", carAttributes);
    }
}
