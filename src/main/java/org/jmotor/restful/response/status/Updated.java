package org.jmotor.restful.response.status;

import javax.ws.rs.core.Response;

/**
 * Component:
 * Description:
 * Date: 14-4-29
 *
 * @author Andy Ai
 */
public class Updated implements StatusBuilder {
    @Override
    public Response build(Object... parameters) {
        return builder(parameters).build();
    }

    @Override
    public Response.ResponseBuilder builder(Object... parameters) {
        return Response.status(Response.Status.NO_CONTENT);
    }
}
