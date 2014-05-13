package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.response.ErrorBuilder;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Component:
 * Description:
 * Date: 14-4-29
 *
 * @author Andy Ai
 */
@Provider
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {
    @Override
    public Response toResponse(IllegalArgumentException exception) {
        String message = exception.getLocalizedMessage();
        return ErrorBuilder.newBuilder()
                .message(message)
                .error("illegal_parameter", message)
                .build(Response.Status.BAD_REQUEST);
    }
}
