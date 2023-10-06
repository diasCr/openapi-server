package ch.swisscard.demo.server.rest;

import org.openapitools.model.CarDataMap;

public class CarDataWrapper extends CarDataMap {

    public CarDataWrapper(String carAttributes) {
        super(carAttributes);
        super.putAdditionalProperty("carAttributes", carAttributes);
    }
}
