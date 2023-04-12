package la.opentechlab.training.basicwebapp.repository;

import la.opentechlab.training.basicwebapp.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    Optional<EmployeeEntity> findByEmployeeId(Integer employeeId);

    List<EmployeeEntity> findAllByOrderByEmployeeRole();

}
