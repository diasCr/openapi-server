package ch.swisscard.demo.server;

import org.openapitools.model.NewTaskData;

public class NewTaskWrapper extends NewTaskData {
    public NewTaskWrapper(String newAttribute) {
        super(newAttribute);
        super.putAdditionalProperty("newAttribute", newAttribute);
    }
}
