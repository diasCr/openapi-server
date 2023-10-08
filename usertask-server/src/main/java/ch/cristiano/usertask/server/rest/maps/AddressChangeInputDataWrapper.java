package ch.cristiano.usertask.server.rest.maps;

import org.openapitools.maps.model.AddressChangeInputData;

public class AddressChangeInputDataWrapper extends AddressChangeInputData {
    public AddressChangeInputDataWrapper(String oldAddressLine1, String newAddressLine1, String evidenceDocumentId) {
        super(oldAddressLine1, newAddressLine1, evidenceDocumentId);
        super.putAdditionalProperty("oldAddressLine1", oldAddressLine1);
        super.putAdditionalProperty("newAddressLine1", newAddressLine1);
        super.putAdditionalProperty("evidenceDocumentId", evidenceDocumentId);
    }

}
