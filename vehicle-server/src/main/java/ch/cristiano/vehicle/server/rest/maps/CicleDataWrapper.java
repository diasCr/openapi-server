package ch.cristiano.vehicle.server.rest.maps;

import org.openapitools.maps.model.CicleDataMap;

public class CicleDataWrapper extends CicleDataMap {

    public CicleDataWrapper(String cicleAttributes, Integer cicleCountWheels) {
        super(cicleAttributes, cicleCountWheels);
        super.putAdditionalProperty("cicleAttributes", cicleAttributes);
        super.putAdditionalProperty("cicleCountWheels", cicleCountWheels);
    }
}
