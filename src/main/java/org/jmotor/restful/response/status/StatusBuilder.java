package org.jmotor.restful.response.status;

import javax.ws.rs.core.Response;

/**
 * Component:
 * Description:
 * Date: 14-4-29
 *
 * @author Andy Ai
 */
public interface StatusBuilder {
    Response build(Object... parameters);

    Response.ResponseBuilder builder(Object... parameters);
}
