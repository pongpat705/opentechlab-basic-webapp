package la.opentechlab.training.basicwebapp.repository;

import la.opentechlab.training.basicwebapp.entity.EmployeeEntity;
import la.opentechlab.training.basicwebapp.model.EmployeeCriteria;
import la.opentechlab.training.basicwebapp.model.EmployeeModel;

import java.util.List;

public interface EmployeeNativeRepository {

    List<EmployeeModel> findEmployeeByCriteria(EmployeeCriteria employeeCriteria);
}
