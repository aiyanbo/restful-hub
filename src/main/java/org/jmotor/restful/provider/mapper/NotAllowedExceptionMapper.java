package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.response.Builder;

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
    @Override
    public Response toResponse(NotAllowedException e) {
        return Builder.newBuilder()
                .message(e.getLocalizedMessage())
                .error("method_not_allowed", e.getLocalizedMessage())
                .build(Response.Status.METHOD_NOT_ALLOWED);
    }
}
