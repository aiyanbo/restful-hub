package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.response.ErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(EntityExistsExceptionMapper.class);

    @Override
    public Response toResponse(EntityExistsException exception) {
        LOGGER.error(exception.getLocalizedMessage(), exception);
        return ErrorBuilder.newBuilder().message("Entity Already Exists")
                .error("entity_already_exists", exception.getLocalizedMessage())
                .build(Response.Status.CONFLICT);
    }
}
