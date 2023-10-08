package ch.cristiano.usertask.server.rest.oneof;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.openapitools.oneof.api.UsertasksApi;
import org.openapitools.oneof.model.AddressChangeInputData;
import org.openapitools.oneof.model.AddressChangeOutputData;
import org.openapitools.oneof.model.AddressChangeOutputDataAcceptedAddress;
import org.openapitools.oneof.model.AddressChangeOutputDataAcceptedAddressLine;
import org.openapitools.oneof.model.NameChangeInputData;
import org.openapitools.oneof.model.NameChangeOutputData;
import org.openapitools.oneof.model.NameChangeOutputDataAcceptedNewName;
import org.openapitools.oneof.model.NameChangeOutputDataComment;
import org.openapitools.oneof.model.NameChangeOutputDataEvidenceAccepted;
import org.openapitools.oneof.model.NewTaskInputData;
import org.openapitools.oneof.model.NewTaskOutputData;
import org.openapitools.oneof.model.NewTaskOutputDataAnyVariable;
import org.openapitools.oneof.model.SortOrder;
import org.openapitools.oneof.model.Usertask;
import org.openapitools.oneof.model.UsertaskCompletionRequest;
import org.openapitools.oneof.model.UsertaskStatusType;
import org.openapitools.oneof.model.UsertaskType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneOfController implements UsertasksApi {

        @Override
        public ResponseEntity<List<Usertask>> queryUserTasks(@Valid UsertaskType type, @Valid Boolean onlyUnclaimed,
                        @Valid SortOrder sortOrder, @Min(1) @Max(20) @Valid Integer pageSize,
                        @Min(1) @Valid Integer page) {
                List<Usertask> usertasks = this.getUsertasks();
                return ResponseEntity.ok(usertasks);
        }

        @Override
        public ResponseEntity<Void> createUsertaskCompletion(String taskId,
                        @Valid UsertaskCompletionRequest usertaskCompletionRequest) {

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
                NewTaskInputData newTaskData = new NewTaskInputData(UsertaskType.NEW_TASK.name(), "new attribute");
                Usertask usertask03 = new Usertask(null, null, "102", UsertaskStatusType.OPEN.name(),
                                UsertaskType.NEW_TASK.name(), newTaskData);

                NewTaskOutputData newTaskOutputData = new NewTaskOutputData();
                newTaskOutputData.setAnyVariable(new NewTaskOutputDataAnyVariable());

                usertask03.setOutputData(newTaskOutputData);

                return usertask03;
        }

        private Usertask getUsertask02() {
                AddressChangeInputData addressChangeData = new AddressChangeInputData(
                                UsertaskType.ADDRESS_CHANGE_TASK.name(),
                                "Teststrasse 1", "Musterstrasse1",
                                "dummy");
                addressChangeData.setNewCity("NewCity");
                addressChangeData.setOldCity("OldCity");
                Usertask usertask02 = new Usertask(null, null, "101", UsertaskStatusType.OPEN.name(),
                                UsertaskType.ADDRESS_CHANGE_TASK.name(),
                                addressChangeData);

                AddressChangeOutputData addressChangeOutputData = new AddressChangeOutputData();
                addressChangeOutputData.setAcceptedAddress(new AddressChangeOutputDataAcceptedAddress());
                addressChangeOutputData.setAcceptedAddressLine(new AddressChangeOutputDataAcceptedAddressLine());

                usertask02.setOutputData(addressChangeOutputData);

                return usertask02;
        }

        private Usertask getUsertask01() {
                NameChangeInputData nameChangeData = new NameChangeInputData(UsertaskType.NAME_CHANGE_TASK.name(),
                                "Meier",
                                "Muster",
                                "dummy");
                Usertask usertask01 = new Usertask(null, null, "100", UsertaskStatusType.OPEN.name(),
                                UsertaskType.NAME_CHANGE_TASK.name(), nameChangeData);

                NameChangeOutputData nameChangeOutputData = new NameChangeOutputData();
                nameChangeOutputData.setAcceptedNewName(new NameChangeOutputDataAcceptedNewName());
                nameChangeOutputData.setComment(new NameChangeOutputDataComment());
                nameChangeOutputData.setEvidenceAccepted(new NameChangeOutputDataEvidenceAccepted());

                usertask01.setOutputData(nameChangeOutputData);

                return usertask01;
        }

}
