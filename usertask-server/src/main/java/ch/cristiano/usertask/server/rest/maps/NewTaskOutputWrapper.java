package ch.cristiano.usertask.server.rest.maps;

import org.openapitools.maps.model.NewTaskOutputData;
import org.openapitools.maps.model.NewTaskOutputDataAnyVariable;

public class NewTaskOutputWrapper extends NewTaskOutputData {

    public NewTaskOutputWrapper(NewTaskOutputDataAnyVariable anyVariable) {
        super.putAdditionalProperty("anyVariable", anyVariable);
    }

}
