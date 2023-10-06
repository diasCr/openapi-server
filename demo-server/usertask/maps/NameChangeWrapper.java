package ch.swisscard.demo.server;

import org.openapitools.model.NameChangeData;

public class NameChangeWrapper extends NameChangeData {

    public NameChangeWrapper(String oldName, String newName, String evidenceDocumentId) {
        super(oldName, newName, evidenceDocumentId);
        super.putAdditionalProperty("oldName", oldName);
        super.putAdditionalProperty("newName", newName);
        super.putAdditionalProperty("evidenceDocumentId", evidenceDocumentId);
    }

}
