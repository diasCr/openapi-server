package ch.swisscard.demo.server.rest;

import org.openapitools.model.TruckDataMap;

public class TruckDataWrapper extends TruckDataMap {

    public TruckDataWrapper(String truckAttributes, String truckCountWheels) {
        super(truckAttributes, truckCountWheels);
        super.putAdditionalProperty("truckAttributes", truckAttributes);
        super.putAdditionalProperty("truckCountWheels", truckCountWheels);
    }

}
