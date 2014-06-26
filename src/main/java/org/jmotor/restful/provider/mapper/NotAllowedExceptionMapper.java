package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.response.ErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Component:
 * Description:
 * Date: 14-4-28
 *
 * @author Andy Ai
 */
@Provider
public class NotAllowedExceptionMapper implements ExceptionMapper<NotAllowedException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotAllowedExceptionMapper.class);

    @Override
    public Response toResponse(NotAllowedException e) {
        LOGGER.error(e.getLocalizedMessage(), e);
        String message = e.getLocalizedMessage();
        return ErrorBuilder.newBuilder()
                .message(message)
                .error("method_not_allowed", message)
                .build(Response.Status.METHOD_NOT_ALLOWED);
    }
}
