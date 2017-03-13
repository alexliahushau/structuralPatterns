package com.epam.mentoring.lesfree.db;

import com.epam.mentoring.lesfree.client.Client;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Aliaksandr_Liahushau on 3/11/2017.
 */
public class FacadeTest {

    @Test
    public void test_H2() {
        new Client().testH2DB();;
    }

    @Test
    public void test_Derby() {
        new Client().testDerbyDB();
    }

    @Test
    public void test_HyperSQL() {
        new Client().testHsqlDB();
    }

}
