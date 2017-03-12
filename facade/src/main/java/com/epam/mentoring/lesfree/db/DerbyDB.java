package com.epam.mentoring.lesfree.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by Aliaksandr_Liahushau on 3/11/2017.
 */
public class DerbyDB implements db {
    final static Logger LOG = LoggerFactory.getLogger(DerbyDB.class);
    final static String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    final static String URL = "jdbc:derby:memory:codejava/test;create=true";
    final static String QUERY = "select * from test";

    @Override
    public void testConnection() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stat = conn.createStatement()) {
            Class.forName(DRIVER);

            stat.execute("create table test(id int primary key, name varchar(255))");
            stat.execute("insert into test values(1, 'Hello from DERBY DB')");

            try (ResultSet rs = stat.executeQuery(QUERY)) {
                while (rs.next()) {
                    LOG.debug("Reading data from db : [{}]", rs.getString("name"));
                }
            } catch (SQLException e) {
                LOG.error("Failed to execute query [{}], [{}]", QUERY, e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            LOG.error("Could not find db driver [{}], [{}]", DRIVER, e.getMessage());
        } catch (SQLException e) {
            LOG.error("Error [{}]", URL, e.getMessage());
        }
    }
}