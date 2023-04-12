package la.opentechlab.training.basicwebapp.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeCriteria {
    private Integer employeeId;
    private String employeeFirstname;
    private String employeeLastname;
    private String employeeRole;
    private LocalDateTime employeeJoinDate;
}
