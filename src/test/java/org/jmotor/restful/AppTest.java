package org.jmotor.restful;

import org.jmotor.restful.core.LinkRelation;
import org.jmotor.restful.response.Success;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test() {
        Response response = Success.Created.builder("", "", new Date()).link("http://bb.c", LinkRelation.SELF).build();
        assert response.getHeaders().containsKey("Link");
    }
}
