package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.response.Builder;

import javax.persistence.EntityExistsException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Component:
 * Description:
 * Date: 14-5-13
 *
 * @author Andy Ai
 */
public class EntityExistsExceptionMapper implements ExceptionMapper<EntityExistsException> {
    @Override
    public Response toResponse(EntityExistsException exception) {
        return Builder.newBuilder().message("Entity Already Exists")
                .error("entity_already_exists", exception.getLocalizedMessage())
                .build(Response.Status.CONFLICT);
    }
}
