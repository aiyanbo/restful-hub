package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.response.Builder;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
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
public class ThrowableMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable throwable) {
        if (throwable instanceof WebApplicationException) {
            WebApplicationException e = (WebApplicationException) throwable;
            String message = e.getLocalizedMessage();
            Response response = e.getResponse();
            String code = response.getStatusInfo().getReasonPhrase().replace(" ", "_").toLowerCase();
            org.jmotor.restful.response.Error error = Builder.newBuilder().message(message)
                    .error(code, message).build();
            return Response.fromResponse(response).entity(error).type(MediaType.APPLICATION_JSON_TYPE).build();
        }
        return Builder.newBuilder()
                .message("Server has error.")
                .error("internal_server_error", throwable.getLocalizedMessage())
                .build(Response.Status.INTERNAL_SERVER_ERROR);
    }
}
