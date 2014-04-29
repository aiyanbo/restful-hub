package org.jmotor.restful;

import org.jmotor.restful.response.Success;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test() {
        Success.Created.build("https://server.com/v1/", "domain", "0001");
    }
}
