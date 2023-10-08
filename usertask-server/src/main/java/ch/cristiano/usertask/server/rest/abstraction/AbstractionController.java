package ch.cristiano.usertask.server.rest.abstraction;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.openapitools.abstraction.api.UsertasksApi;
import org.openapitools.abstraction.model.AddressChangeInputData;
import org.openapitools.abstraction.model.AddressChangeOutputData;
import org.openapitools.abstraction.model.AddressChangeOutputDataAllOfAcceptedAddress;
import org.openapitools.abstraction.model.AddressChangeOutputDataAllOfAcceptedAddressLine;
import org.openapitools.abstraction.model.NameChangeInputData;
import org.openapitools.abstraction.model.NameChangeOutputData;
import org.openapitools.abstraction.model.NameChangeOutputDataAllOfAcceptedNewName;
import org.openapitools.abstraction.model.NameChangeOutputDataAllOfComment;
import org.openapitools.abstraction.model.NameChangeOutputDataAllOfEvidenceAccepted;
import org.openapitools.abstraction.model.NewTaskInputData;
import org.openapitools.abstraction.model.NewTaskOutputData;
import org.openapitools.abstraction.model.NewTaskOutputDataAllOfAnyVariable;
import org.openapitools.abstraction.model.SortOrder;
import org.openapitools.abstraction.model.Usertask;
import org.openapitools.abstraction.model.UsertaskCompletionRequest;
import org.openapitools.abstraction.model.UsertaskStatusType;
import org.openapitools.abstraction.model.UsertaskType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbstractionController implements UsertasksApi {

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
                NewTaskInputData newTaskInputData = new NewTaskInputData(UsertaskType.NEW_TASK.name(), "new attribute");
                NewTaskOutputData newTaskOutputData = new NewTaskOutputData();
                newTaskOutputData.setAnyVariable(new NewTaskOutputDataAllOfAnyVariable());
                Usertask usertask03 = new Usertask(null, null, "102", UsertaskStatusType.OPEN.name(),
                                UsertaskType.NEW_TASK.name(), newTaskInputData);
                usertask03.setOutputData(newTaskOutputData);
                return usertask03;
        }

        private Usertask getUsertask02() {
                AddressChangeInputData addressChangeInputData = new AddressChangeInputData(
                                UsertaskType.ADDRESS_CHANGE_TASK.name(),
                                "Teststrasse 1", "Musterstrasse1",
                                "dummy");
                addressChangeInputData.setNewCity("NewCity");
                addressChangeInputData.setOldCity("OldCity");
                AddressChangeOutputData addressChangeOutputData = new AddressChangeOutputData();
                addressChangeOutputData.setAcceptedAddress(new AddressChangeOutputDataAllOfAcceptedAddress());
                addressChangeOutputData.setAcceptedAddressLine(new AddressChangeOutputDataAllOfAcceptedAddressLine());
                Usertask usertask02 = new Usertask(null, null, "101", UsertaskStatusType.OPEN.name(),
                                UsertaskType.ADDRESS_CHANGE_TASK.name(),
                                addressChangeInputData);
                usertask02.setOutputData(addressChangeOutputData);
                return usertask02;
        }

        private Usertask getUsertask01() {
                NameChangeInputData nameChangeInputData = new NameChangeInputData(UsertaskType.NAME_CHANGE_TASK.name(),
                                "Meier",
                                "Muster",
                                "dummy");
                nameChangeInputData.setSomething("something");

                NameChangeOutputData nameChangeOutputData = new NameChangeOutputData();
                nameChangeOutputData
                                .setEvidenceAccepted(new NameChangeOutputDataAllOfEvidenceAccepted());
                nameChangeOutputData.setComment(new NameChangeOutputDataAllOfComment());
                nameChangeOutputData.setAcceptedNewName(new NameChangeOutputDataAllOfAcceptedNewName());

                Usertask usertask01 = new Usertask(null, null, "100", UsertaskStatusType.OPEN.name(),
                                UsertaskType.NAME_CHANGE_TASK.name(), nameChangeInputData);
                usertask01.setOutputData(nameChangeOutputData);
                return usertask01;
        }
}
