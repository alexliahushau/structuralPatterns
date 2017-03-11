package com.epam.mentoring.lesfree.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Aliaksandr_Liahushau on 3/11/2017.
 */
public class DerbyFacade implements Facade {
    final static Logger LOG = LoggerFactory.getLogger(DerbyFacade.class);
    final static String URL = "jdbc:derby:memory:codejava/test;create=true";

    @Override
    public Connection getConnection() throws SQLException {

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            LOG.error("Failed to load derby driver: [{}]", e.getMessage());
        }

        return DriverManager.getConnection(URL);
    }
}
