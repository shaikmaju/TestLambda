package com.ilantus.org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLambdaJdbi {
    private static final Logger LOG = LoggerFactory.getLogger(TestLambdaJdbi.class);
    Query query = null;
    Connection con;
    Handle handle = null;
    Employee emp;

    public List<Employee> getEmployeeDetails() {
        List<Employee> empList = new ArrayList<Employee>();
        String sql = "select * from employee";
        try {
            LOG.info("getEmployeeDetails:Before Excuteing the query= " + query);
            // Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useSSL=false", "root", "root123");
            LOG.info("getEmployeeDetails : Executing query = {}", sql);
            handle = Jdbi.open(con);
            query = handle.createQuery(sql);

            RowMapper<Employee> mapper = (rs, ctx) -> {
                try {
                    emp.setEid(rs.getInt("eid"));
                    emp.setEmp_Name(rs.getString("ename"));
                    emp.setMbl_no(rs.getString("mobileno"));
                    emp.setMail_Id(rs.getString("mailId"));
                    emp.setDesignation(rs.getString("design"));
                } catch (Exception e) {
                    LOG.error(e.getMessage(), e);
                    throw new SQLException(e);

                }

                return emp;

            };
            Optional<List<Employee>> optional = Optional.of(query.map(mapper)
                                                                 .list());
            if (optional.isPresent()) {
                empList = optional.get();
            }
            LOG.info(" getEmployeeDetails : After Executing query... the ResultSet size = {}", empList.size());
            handle.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empList;

    }

}
