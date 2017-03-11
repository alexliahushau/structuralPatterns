package com.epam.mentoring.lesfree.facade;

import com.epam.mentoring.lesfree.client.Client;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Aliaksandr_Liahushau on 3/11/2017.
 */
public class FacadeTest {

    @Test
    public void test_H2() {
        final Client client = new Client(new H2Facade());
        client.testConnection();
    }

    @Test
    public void test_Derby() {
        final Client client = new Client(new DerbyFacade());
        client.testConnection();
    }

    @Test
    public void test_HyperSQL() {
        final Client client = new Client(new HsqlFacade());
        client.testConnection();
    }

}
