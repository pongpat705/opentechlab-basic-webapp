package la.opentechlab.training.basicwebapp.repository.impl;

import la.opentechlab.training.basicwebapp.entity.EmployeeEntity;
import la.opentechlab.training.basicwebapp.model.EmployeeCriteria;
import la.opentechlab.training.basicwebapp.model.EmployeeModel;
import la.opentechlab.training.basicwebapp.repository.EmployeeNativeRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeNativeRepositoryImpl implements EmployeeNativeRepository {

    private JdbcTemplate jdbcTemplate;

    public EmployeeNativeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<EmployeeModel> findEmployeeByCriteria(EmployeeCriteria employeeCriteria) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT employee_id\n" +
                ",employee_firstname\n" +
                ",employee_lastname\n" +
                ",employee_role\n" +
                ",employee_join_date\n" +
                ",is_delete\n" +
                ",created_date\n" +
                ",created_by\n" +
                ",updated_date\n" +
                ",updated_by\n" +
                "from employee where 1=1 ");

        List<Object> params = new ArrayList<>();

        if(null != employeeCriteria.getEmployeeId()){
            sb.append(" and employee_id = ? ");
            params.add(employeeCriteria.getEmployeeId());
        }
        if(null != employeeCriteria.getEmployeeFirstname()){
            sb.append(" and employee_firstname = ? ");
            params.add(employeeCriteria.getEmployeeFirstname());
        }
        if(null != employeeCriteria.getEmployeeLastname()){
            sb.append(" and employee_lastname = ? ");
            params.add(employeeCriteria.getEmployeeLastname());
        }
        if(null != employeeCriteria.getEmployeeRole()){
            sb.append(" and employee_role = ? ");
            params.add(employeeCriteria.getEmployeeRole());
        }
        if(null != employeeCriteria.getEmployeeJoinDate()){
            sb.append(" and employee_join_date = ? ");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String dateStr = dateTimeFormatter.format(employeeCriteria.getEmployeeJoinDate());
            params.add(dateStr);
        }

        return this.jdbcTemplate.query(sb.toString(), new RowMapper<EmployeeModel>() {
            @Override
            public EmployeeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                EmployeeModel x = new EmployeeModel();
                int col = 1;
                x.setEmployeeId(rs.getInt(col++));
                x.setEmployeeFirstname(rs.getString(col++));
                x.setEmployeeLastname(rs.getString(col++));
                x.setEmployeeRole(rs.getString(col++));

                Timestamp joinTimeStamp = rs.getTimestamp(col++);
                if(null != joinTimeStamp) x.setEmployeeJoinDate(joinTimeStamp.toLocalDateTime());

                x.setIsDelete(rs.getString(col++));

                Timestamp createTimeStamp = rs.getTimestamp(col++);
                if(null != createTimeStamp) x.setCreateDate(createTimeStamp.toLocalDateTime());
                x.setCreateBy(rs.getString(col++));

                Timestamp updateTimeStamp = rs.getTimestamp(col++);
                if(null != updateTimeStamp) x.setUpdateDate(updateTimeStamp.toLocalDateTime());

                x.setUpdateBy(rs.getString(col++));
                return x;
            }
        }, params.toArray());
    }
}
