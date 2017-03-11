package com.epam.mentoring.lesfree.facade;

import org.h2.tools.DeleteDbFiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by Aliaksandr_Liahushau on 3/11/2017.
 */
public class H2Facade implements Facade {
    final static Logger LOG = LoggerFactory.getLogger(H2Facade.class);

    @Override
    public Connection getConnection() throws SQLException {
        DeleteDbFiles.execute("~", "test", true);

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            LOG.error("Failed to load h2 driver: [{}]", e.getMessage());
        }

        return DriverManager.getConnection("jdbc:h2:~/test");
    }
}
