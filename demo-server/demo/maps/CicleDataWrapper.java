package ch.swisscard.demo.server.rest;

import org.openapitools.model.CicleDataMap;

public class CicleDataWrapper extends CicleDataMap {

    public CicleDataWrapper(String cicleAttributes, String cicleCountWheels) {
        super(cicleAttributes, cicleCountWheels);
        super.putAdditionalProperty("cicleAttributes", cicleAttributes);
        super.putAdditionalProperty("cicleCountWheels", cicleCountWheels);
    }
}
