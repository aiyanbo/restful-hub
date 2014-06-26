package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.exception.NotImplementedException;
import org.jmotor.restful.response.ErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(NotImplementedExceptionMapper.class);

    @Override
    public Response toResponse(NotImplementedException exception) {
        LOGGER.error(exception.getLocalizedMessage(), exception);
        String message = exception.getLocalizedMessage();
        return ErrorBuilder.newBuilder().message(message)
                .error("server_not_implemented", message).build(Response.Status.NOT_IMPLEMENTED);
    }
}
