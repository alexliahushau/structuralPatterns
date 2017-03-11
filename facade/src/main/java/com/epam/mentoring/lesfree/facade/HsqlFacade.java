package com.epam.mentoring.lesfree.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Aliaksandr_Liahushau on 3/11/2017.
 */
public class HsqlFacade implements Facade {
    final static Logger LOG = LoggerFactory.getLogger(HsqlFacade.class);
    final static String URL = "jdbc:hsqldb:mem:mymemdb\", \"SA\", \"\"";

    @Override
    public Connection getConnection() throws SQLException {

        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            LOG.error("Failed to load hsql driver: [{}]", e.getMessage());
        }

        return DriverManager.getConnection(URL);
    }
}
