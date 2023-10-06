package ch.swisscard.demo.server.rest;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.openapitools.api.UsertasksApi;
import org.openapitools.model.AddressChangeData;
import org.openapitools.model.NameChangeData;
import org.openapitools.model.NewTaskData;
import org.openapitools.model.SortOrder;
import org.openapitools.model.Usertask;
import org.openapitools.model.UsertaskStatusType;
import org.openapitools.model.UsertaskType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsertaskController implements UsertasksApi {

        @Override
        public ResponseEntity<List<Usertask>> queryUserTasks(@Valid UsertaskType type, @Valid Boolean onlyUnclaimed,
                        @Valid SortOrder sortOrder, @Min(1) @Max(20) @Valid Integer pageSize,
                        @Min(1) @Valid Integer page) {
                List<Usertask> usertasks = this.getUsertasks();
                return ResponseEntity.ok(usertasks);
        }

        private List<Usertask> getUsertasks() {
                List<Usertask> usertasks = new ArrayList<>();

                NameChangeData nameChangeData = new NameChangeData(UsertaskType.NAME_CHANGE_TASK.name(), "Meier",
                                "Muster",
                                "dummy");
                Usertask usertask01 = new Usertask(null, null, "100", UsertaskStatusType.OPEN.name(),
                                UsertaskType.NAME_CHANGE_TASK.name(), nameChangeData);

                AddressChangeData addressChangeData = new AddressChangeData(UsertaskType.ADDRESS_CHANGE_TASK.name(),
                                "Teststrasse 1", "Musterstrasse1",
                                "dummy");
                addressChangeData.setNewCity("NewCity");
                addressChangeData.setOldCity("OldCity");
                Usertask usertask02 = new Usertask(null, null, "101", UsertaskStatusType.OPEN.name(),
                                UsertaskType.ADDRESS_CHANGE_TASK.name(),
                                addressChangeData);

                NewTaskData newTaskData = new NewTaskData(UsertaskType.NEW_TASK.name(), "new attribute");
                Usertask usertask03 = new Usertask(null, null, "102", UsertaskStatusType.OPEN.name(),
                                UsertaskType.NEW_TASK.name(), newTaskData);

                usertasks.add(usertask01);
                usertasks.add(usertask02);
                // usertasks.add(usertask03);

                return usertasks;
        }

}
