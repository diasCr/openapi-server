package ch.cristiano.usertask.server.rest.maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.openapitools.maps.api.UsertasksApi;
import org.openapitools.maps.model.AddressChangeInputData;
import org.openapitools.maps.model.AddressChangeOutputData;
import org.openapitools.maps.model.AddressChangeOutputDataAcceptedAddress;
import org.openapitools.maps.model.AddressChangeOutputDataAcceptedAddressLine;
import org.openapitools.maps.model.NameChangeInputData;
import org.openapitools.maps.model.NameChangeOutputData;
import org.openapitools.maps.model.NameChangeOutputDataAcceptedNewName;
import org.openapitools.maps.model.NameChangeOutputDataComment;
import org.openapitools.maps.model.NameChangeOutputDataEvidenceAccepted;
import org.openapitools.maps.model.NewTaskInputData;
import org.openapitools.maps.model.NewTaskOutputData;
import org.openapitools.maps.model.NewTaskOutputDataAnyVariable;
import org.openapitools.maps.model.SortOrder;
import org.openapitools.maps.model.Usertask;
import org.openapitools.maps.model.UsertaskStatusType;
import org.openapitools.maps.model.UsertaskType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapsController implements UsertasksApi {

        @Override
        public ResponseEntity<List<Usertask>> queryUserTasks(@Valid UsertaskType type, @Valid Boolean onlyUnclaimed,
                        @Valid SortOrder sortOrder, @Min(1) @Max(20) @Valid Integer pageSize,
                        @Min(1) @Valid Integer page) {
                List<Usertask> usertasks = this.getUsertasks();
                return ResponseEntity.ok(usertasks);
        }

        @Override
        public ResponseEntity<Void> createUsertaskCompletion(String taskId, @Valid Map<String, Object> requestBody) {
                return ResponseEntity.created(null).build();
        }

        private List<Usertask> getUsertasks() {
                List<Usertask> usertasks = new ArrayList<>();

                Usertask usertask01 = getUsertask01();

                Usertask usertask02 = getUsertask02();

                Usertask usertask03 = getUsertask03();

                usertasks.add(usertask01);
                usertasks.add(usertask02);
                // usertasks.add(usertask03);

                return usertasks;
        }

        private Usertask getUsertask03() {
                NewTaskInputData newTaskInputData = new NewTaskInputDataWrapper("something");
                Usertask usertask03 = new Usertask(null, null, "102", UsertaskStatusType.OPEN.name(),
                                UsertaskType.NEW_TASK.name(), newTaskInputData.getAdditionalProperties());

                NewTaskOutputData newTaskOutputData = new NewTaskOutputWrapper(new NewTaskOutputDataAnyVariable());
                usertask03.setOutputData(newTaskOutputData.getAdditionalProperties());
                return usertask03;
        }

        private Usertask getUsertask02() {
                AddressChangeInputData addressChangeData = new AddressChangeInputDataWrapper("Teststrasse 1",
                                "Musterstrasse1",
                                "dummy");
                addressChangeData.putAdditionalProperty("newCity", "NewCity");
                addressChangeData.putAdditionalProperty("oldCity", "OldCity");
                Usertask usertask02 = new Usertask(null, null, "101", UsertaskStatusType.OPEN.name(),
                                UsertaskType.ADDRESS_CHANGE_TASK.name(),
                                addressChangeData.getAdditionalProperties());

                AddressChangeOutputData addressChangeOutputData = new AddressChangeOutputDataWrapper(
                                new AddressChangeOutputDataAcceptedAddress(),
                                new AddressChangeOutputDataAcceptedAddressLine());
                usertask02.setOutputData(addressChangeOutputData.getAdditionalProperties());

                return usertask02;
        }

        private Usertask getUsertask01() {
                NameChangeInputData nameChangeData = new NameChangeInputDataWrapper("Meier", "Muster", "dummy");
                Usertask usertask01 = new Usertask(null, null, "100", UsertaskStatusType.OPEN.name(),
                                UsertaskType.NAME_CHANGE_TASK.name(),
                                nameChangeData.getAdditionalProperties());

                NameChangeOutputData nameChangeOutputData = new NameChangeOutputDataWrapper(
                                new NameChangeOutputDataEvidenceAccepted(), new NameChangeOutputDataAcceptedNewName(),
                                new NameChangeOutputDataComment());
                usertask01.setOutputData(nameChangeOutputData.getAdditionalProperties());

                return usertask01;
        }

}
