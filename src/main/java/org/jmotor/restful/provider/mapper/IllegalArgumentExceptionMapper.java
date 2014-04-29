package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.response.Builder;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Component:
 * Description:
 * Date: 14-4-29
 *
 * @author Andy Ai
 */
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {
    @Override
    public Response toResponse(IllegalArgumentException exception) {
        return Builder.newBuilder()
                .message(exception.getLocalizedMessage())
                .error("illegal_parameter", exception.getLocalizedMessage())
                .build(Response.Status.BAD_REQUEST);
    }
}
