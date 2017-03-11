package com.epam.mentoring.lesfree.client;

import com.epam.mentoring.lesfree.facade.Facade;
import com.epam.mentoring.lesfree.facade.H2Facade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by Aliaksandr_Liahushau on 3/11/2017.
 */
public class Client {
    final static Logger LOG = LoggerFactory.getLogger(Client.class);

    private Facade facade;

    public Client(Facade facade) {
        this.facade = facade;
    }

    public void testConnection() {
        try (Connection conn = this.facade.getConnection();
             Statement stat = conn.createStatement()) {
            stat.execute("create table test(id int primary key, name varchar(255))");
            stat.execute("insert into test values(1, 'Hello')");
            try (ResultSet rs = stat.executeQuery("select * from test")) {
                while (rs.next()) {
                    LOG.debug("Reading data from db : [{}]", rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            LOG.error("Failed to get connection [{}]", e.getMessage());
        }
    }

}
