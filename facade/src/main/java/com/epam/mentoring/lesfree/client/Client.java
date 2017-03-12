package com.epam.mentoring.lesfree.client;

import com.epam.mentoring.lesfree.db.DerbyDB;
import com.epam.mentoring.lesfree.db.H2DB;
import com.epam.mentoring.lesfree.db.HsqlDB;
import com.epam.mentoring.lesfree.db.db;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by Aliaksandr_Liahushau on 3/11/2017.
 */
public class Client {
    final static Logger LOG = LoggerFactory.getLogger(Client.class);

    private db derby;
    private db h2;
    private db hsql;

    public Client() {
        this.derby = new DerbyDB();
        this.h2 = new H2DB();
        this.hsql = new HsqlDB();
    }

    public void testDerbyDB() {
        this.derby.testConnection();
    }

    public void testH2DB() {
        this.h2.testConnection();
    }

    public void testHsqlDB() {
        this.hsql.testConnection();
    }

}
