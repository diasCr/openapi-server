package ch.cristiano.usertask.server.rest.maps;

import org.openapitools.maps.model.NameChangeInputData;

public class NameChangeInputDataWrapper extends NameChangeInputData {

    public NameChangeInputDataWrapper(String oldName, String newName, String evidenceDocumentId) {
        super(oldName, newName, evidenceDocumentId);
        super.putAdditionalProperty("oldName", oldName);
        super.putAdditionalProperty("newName", newName);
        super.putAdditionalProperty("evidenceDocumentId", evidenceDocumentId);
    }

}
