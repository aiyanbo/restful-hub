package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.response.Builder;

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
    @Override
    public Response toResponse(ForbiddenException exception) {
        Response originalResponse = exception.getResponse();
        String message = exception.getLocalizedMessage();
        org.jmotor.restful.response.Error error = Builder.newBuilder().message(message)
                .error(originalResponse.getStatusInfo().getReasonPhrase().toLowerCase(), message).build();
        return Response.fromResponse(originalResponse).entity(error).type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
