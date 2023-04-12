package la.opentechlab.training.basicwebapp.restcontroller;

import la.opentechlab.training.basicwebapp.model.EmployeeCriteria;
import la.opentechlab.training.basicwebapp.model.EmployeeModel;
import la.opentechlab.training.basicwebapp.service.EmployeeService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/all")
    public List<EmployeeModel> findAllEmployee(){
        return this.employeeService.findAllEmployee();
    }

//    @GetMapping("/employee/all/orderby")
//    public List<EmployeeModel> findAllEmployeeOrderBy(@RequestParam Sort sort){
//        Sort orders = new Sort();
//        return this.employeeService.findAllEmployeeOrderBy(sort);
//    }

    @GetMapping("/employee")
    public EmployeeModel findByEmployeeId(@RequestParam Integer employeeId){
        return this.employeeService.findByEmployeeId(employeeId);
    }
    @PostMapping("/employee")
    public EmployeeModel insertEmployee(@RequestBody EmployeeModel employeeModel){
        return this.employeeService.insertEmployee(employeeModel);
    }
    @PatchMapping("/employee")
    public EmployeeModel patchEmployee(@RequestBody EmployeeModel employeeModel){
        return this.employeeService.updateEmployee(employeeModel);
    }


    @PostMapping("/inquiry/employee")
    public List<EmployeeModel> findAllEmployeeByCriteria(@RequestBody EmployeeCriteria employeeCriteria){
        return this.employeeService.findAllEmployeeByCriteria(employeeCriteria);
    }
}
