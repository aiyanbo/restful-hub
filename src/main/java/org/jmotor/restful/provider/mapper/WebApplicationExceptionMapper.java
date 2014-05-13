package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.response.ErrorBuilder;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Component:
 * Description:
 * Date: 14-5-13
 *
 * @author Andy Ai
 */
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {
    @Override
    public Response toResponse(WebApplicationException exception) {
        String message = exception.getLocalizedMessage();
        Response response = exception.getResponse();
        String code = response.getStatusInfo().getReasonPhrase().replace(" ", "_").toLowerCase();
        org.jmotor.restful.response.Error error = ErrorBuilder.newBuilder().message(message)
                .error(code, message).build();
        return Response.fromResponse(response).entity(error).type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
