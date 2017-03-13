package com.epam.mentoring.lesfree.db;

import org.h2.tools.DeleteDbFiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by Aliaksandr_Liahushau on 3/11/2017.
 */
public class H2DB implements db {
    final static Logger LOG = LoggerFactory.getLogger(H2DB.class);
    final static String DRIVER = "org.h2.Driver";
    final static String QUERY = "select * from test";
    final static String URL = "jdbc:h2:~/test";

    @Override
    public void testConnection() {
        DeleteDbFiles.execute("~", "test", true);
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stat = conn.createStatement()) {
            Class.forName(DRIVER);

            stat.execute("create table test(id int primary key, name varchar(255))");
            stat.execute("insert into test values(1, 'Hello from H2 DB')");

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
