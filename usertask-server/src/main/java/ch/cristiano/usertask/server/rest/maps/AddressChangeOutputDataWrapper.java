package ch.cristiano.usertask.server.rest.maps;

import org.openapitools.maps.model.AddressChangeOutputData;
import org.openapitools.maps.model.AddressChangeOutputDataAcceptedAddress;
import org.openapitools.maps.model.AddressChangeOutputDataAcceptedAddressLine;

public class AddressChangeOutputDataWrapper extends AddressChangeOutputData {

    public AddressChangeOutputDataWrapper(AddressChangeOutputDataAcceptedAddress acceptedAddress,
            AddressChangeOutputDataAcceptedAddressLine acceptedAddressLine) {

        super.putAdditionalProperty("acceptedAddress", acceptedAddress);
        super.putAdditionalProperty("acceptedAddressLine", acceptedAddressLine);

    }

}
