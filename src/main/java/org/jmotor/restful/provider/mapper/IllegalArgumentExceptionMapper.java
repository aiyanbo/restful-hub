package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.response.ErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(IllegalArgumentExceptionMapper.class);

    @Override
    public Response toResponse(IllegalArgumentException exception) {
        LOGGER.error(exception.getLocalizedMessage(), exception);
        String message = exception.getLocalizedMessage();
        return ErrorBuilder.newBuilder()
                .message(message)
                .error("illegal_parameter", message)
                .build(Response.Status.BAD_REQUEST);
    }
}
