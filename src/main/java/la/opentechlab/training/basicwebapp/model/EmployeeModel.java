package la.opentechlab.training.basicwebapp.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeModel {
    private Integer employeeId;
    private String employeeFirstname;
    private String employeeLastname;
    private String employeeRole;
    private LocalDateTime employeeJoinDate;
    private String isDelete;
    private LocalDateTime createDate;
    private String createBy;
    private LocalDateTime updateDate;
    private String updateBy;
}
