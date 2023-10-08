package ch.cristiano.usertask.server.rest.maps;

import org.openapitools.maps.model.NewTaskInputData;

public class NewTaskInputDataWrapper extends NewTaskInputData {
    public NewTaskInputDataWrapper(String newAttribute) {
        super(newAttribute);
        super.putAdditionalProperty("newAttribute", newAttribute);
    }
}
