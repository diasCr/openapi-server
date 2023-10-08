package ch.cristiano.vehicle.server.rest.maps;

import org.openapitools.maps.model.TruckDataMap;

public class TruckDataWrapper extends TruckDataMap {

    public TruckDataWrapper(String truckAttributes, Integer truckCountWheels) {
        super(truckAttributes, truckCountWheels);
        super.putAdditionalProperty("truckAttributes", truckAttributes);
        super.putAdditionalProperty("truckCountWheels", truckCountWheels);
    }

}
