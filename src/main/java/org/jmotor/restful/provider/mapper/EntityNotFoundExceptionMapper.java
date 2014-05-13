package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.response.ErrorBuilder;

import javax.persistence.EntityNotFoundException;
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
public class EntityNotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException> {
    @Override
    public Response toResponse(EntityNotFoundException e) {
        return ErrorBuilder.newBuilder().message("Entity Not Found").error("missing_entity", e.getLocalizedMessage())
                .build(Response.Status.NOT_FOUND);
    }
}
