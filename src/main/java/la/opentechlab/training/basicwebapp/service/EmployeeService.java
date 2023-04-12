package la.opentechlab.training.basicwebapp.service;

import la.opentechlab.training.basicwebapp.entity.EmployeeEntity;
import la.opentechlab.training.basicwebapp.model.EmployeeCriteria;
import la.opentechlab.training.basicwebapp.model.EmployeeModel;
import la.opentechlab.training.basicwebapp.repository.EmployeeNativeRepository;
import la.opentechlab.training.basicwebapp.repository.EmployeeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private EmployeeNativeRepository employeeNativeRepository;

    public EmployeeService(EmployeeRepository employeeRepository
            , EmployeeNativeRepository employeeNativeRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeNativeRepository = employeeNativeRepository;
    }

    public List<EmployeeModel> findAllEmployee() {

        List<EmployeeEntity> dataList = this.employeeRepository.findAll();
        List<EmployeeModel> result = new ArrayList<>();
        for (EmployeeEntity d: dataList) {
            EmployeeModel x = new EmployeeModel();
            x.setEmployeeId(d.getEmployeeId());
            x.setEmployeeFirstname(d.getEmployeeFirstname());
            x.setEmployeeLastname(d.getEmployeeLastname());
            x.setEmployeeRole(d.getEmployeeRole());
            x.setEmployeeJoinDate(d.getEmployeeJoinDate());
            x.setCreateBy(d.getCreatedBy());
            x.setCreateDate(d.getCreatedDate());
            x.setIsDelete(d.getIsDelete());
            x.setUpdateBy(d.getUpdatedBy());
            x.setUpdateDate(d.getUpdatedDate());
            result.add(x);
        }
        return result;

    }

    public EmployeeModel findByEmployeeId(Integer employeeId) {
        Optional<EmployeeEntity> optionalEmployee = this.employeeRepository.findByEmployeeId(employeeId);
        if(optionalEmployee.isPresent()){
            EmployeeEntity d = optionalEmployee.get();
            EmployeeModel x = new EmployeeModel();
            x.setEmployeeId(d.getEmployeeId());
            x.setEmployeeFirstname(d.getEmployeeFirstname());
            x.setEmployeeLastname(d.getEmployeeLastname());
            x.setEmployeeRole(d.getEmployeeRole());
            x.setEmployeeJoinDate(d.getEmployeeJoinDate());
            x.setCreateBy(d.getCreatedBy());
            x.setCreateDate(d.getCreatedDate());
            x.setIsDelete(d.getIsDelete());
            x.setUpdateBy(d.getUpdatedBy());
            x.setUpdateDate(d.getUpdatedDate());
            return x;
        } else {
            return null;
        }
    }

    public List<EmployeeModel> findAllEmployeeOrderBy(Sort sort) {

        List<EmployeeEntity> dataList = this.employeeRepository.findAll(sort);
        List<EmployeeModel> result = new ArrayList<>();
        for (EmployeeEntity d: dataList) {
            EmployeeModel x = new EmployeeModel();
            x.setEmployeeId(d.getEmployeeId());
            x.setEmployeeFirstname(d.getEmployeeFirstname());
            x.setEmployeeLastname(d.getEmployeeLastname());
            x.setEmployeeRole(d.getEmployeeRole());
            x.setEmployeeJoinDate(d.getEmployeeJoinDate());
            x.setCreateBy(d.getCreatedBy());
            x.setCreateDate(d.getCreatedDate());
            x.setIsDelete(d.getIsDelete());
            x.setUpdateBy(d.getUpdatedBy());
            x.setUpdateDate(d.getUpdatedDate());
            result.add(x);
        }
        return result;

    }

    public List<EmployeeModel> findAllEmployeeByCriteria(EmployeeCriteria employeeCriteria) {

        return this.employeeNativeRepository.findEmployeeByCriteria(employeeCriteria);
    }

    public EmployeeModel insertEmployee(EmployeeModel employeeModel) {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmployeeFirstname(employeeModel.getEmployeeFirstname());
        employeeEntity.setEmployeeLastname(employeeModel.getEmployeeLastname());
        employeeEntity.setEmployeeRole(employeeModel.getEmployeeRole());
        employeeEntity.setEmployeeJoinDate(employeeModel.getEmployeeJoinDate());
        employeeEntity.setIsDelete(employeeModel.getIsDelete());
        employeeEntity.setCreatedDate(LocalDateTime.now());
        employeeEntity.setCreatedBy(employeeModel.getCreateBy());

        this.employeeRepository.save(employeeEntity);
        employeeModel.setEmployeeId(employeeEntity.getEmployeeId());

        return employeeModel;
    }

    public EmployeeModel updateEmployee(EmployeeModel employeeModel) {

        Optional<EmployeeEntity> optionalEmployee = this.employeeRepository.findByEmployeeId(employeeModel.getEmployeeId());
        if(optionalEmployee.isPresent()){
            EmployeeEntity employeeEntity = optionalEmployee.get();
            employeeEntity.setEmployeeFirstname(employeeModel.getEmployeeFirstname());
            employeeEntity.setEmployeeLastname(employeeModel.getEmployeeLastname());
            employeeEntity.setEmployeeRole(employeeModel.getEmployeeRole());
            employeeEntity.setEmployeeJoinDate(employeeModel.getEmployeeJoinDate());
            employeeEntity.setUpdatedDate(LocalDateTime.now());
            employeeEntity.setUpdatedBy(employeeModel.getUpdateBy());

            this.employeeRepository.save(employeeEntity);

            employeeModel.setEmployeeFirstname(employeeEntity.getEmployeeFirstname());
            employeeModel.setEmployeeLastname(employeeEntity.getEmployeeLastname());
            employeeModel.setEmployeeRole(employeeEntity.getEmployeeRole());
            employeeModel.setEmployeeJoinDate(employeeEntity.getEmployeeJoinDate());
            employeeModel.setCreateDate(employeeEntity.getCreatedDate());
            employeeModel.setCreateBy(employeeEntity.getCreatedBy());
            employeeModel.setUpdateDate(employeeEntity.getUpdatedDate());
            employeeModel.setUpdateBy(employeeEntity.getUpdatedBy());
        }

        return employeeModel;
    }
}
