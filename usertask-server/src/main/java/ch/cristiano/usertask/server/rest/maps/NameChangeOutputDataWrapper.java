package ch.cristiano.usertask.server.rest.maps;

import org.openapitools.maps.model.NameChangeOutputData;
import org.openapitools.maps.model.NameChangeOutputDataAcceptedNewName;
import org.openapitools.maps.model.NameChangeOutputDataComment;
import org.openapitools.maps.model.NameChangeOutputDataEvidenceAccepted;

public class NameChangeOutputDataWrapper extends NameChangeOutputData {

    public NameChangeOutputDataWrapper(NameChangeOutputDataEvidenceAccepted evidenceAccepted,
            NameChangeOutputDataAcceptedNewName acceptedNewName, NameChangeOutputDataComment comment) {
        super.putAdditionalProperty("evidenceAccepted", evidenceAccepted);
        super.putAdditionalProperty("acceptedNewName", acceptedNewName);
        super.putAdditionalProperty("comment", comment);
    }

}
