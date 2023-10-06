package ch.swisscard.demo.server;

import org.openapitools.model.AddressChangeData;

public class AddressChangeWrapper extends AddressChangeData {
    public AddressChangeWrapper(String oldAddressLine1, String newAddressLine1, String evidenceDocumentId) {
        super(oldAddressLine1, newAddressLine1, evidenceDocumentId);
        super.putAdditionalProperty("oldAddressLine1", oldAddressLine1);
        super.putAdditionalProperty("newAddressLine1", newAddressLine1);
        super.putAdditionalProperty("evidenceDocumentId", evidenceDocumentId);
    }

}
