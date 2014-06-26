package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.response.ErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Component:
 * Description:
 * Date: 14-4-30
 *
 * @author Andy Ai
 */
public class ForbiddenExceptionMapper implements ExceptionMapper<ForbiddenException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ForbiddenExceptionMapper.class);

    @Override
    public Response toResponse(ForbiddenException exception) {
        LOGGER.error(exception.getLocalizedMessage(), exception);
        Response originalResponse = exception.getResponse();
        String message = exception.getLocalizedMessage();
        org.jmotor.restful.response.Error error = ErrorBuilder.newBuilder().message(message)
                .error(originalResponse.getStatusInfo().getReasonPhrase().toLowerCase(), message).build();
        return Response.fromResponse(originalResponse).entity(error).type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
