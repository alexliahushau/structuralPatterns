package com.epam.mentoring.lesfree.facade;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Aliaksandr_Liahushau on 3/11/2017.
 */
public interface Facade {
    public Connection getConnection() throws SQLException;
}
