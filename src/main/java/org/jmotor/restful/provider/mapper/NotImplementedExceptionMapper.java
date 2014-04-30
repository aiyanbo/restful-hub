package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.exception.NotImplementedException;
import org.jmotor.restful.response.Builder;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Component:
 * Description:
 * Date: 14-4-30
 *
 * @author Andy Ai
 */
public class NotImplementedExceptionMapper implements ExceptionMapper<NotImplementedException> {
    @Override
    public Response toResponse(NotImplementedException exception) {
        String message = exception.getLocalizedMessage();
        return Builder.newBuilder().message(message)
                .error("server_not_implemented", message).build(Response.Status.NOT_IMPLEMENTED);
    }
}
