package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.response.ErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(EntityNotFoundExceptionMapper.class);

    @Override
    public Response toResponse(EntityNotFoundException e) {
        LOGGER.error(e.getLocalizedMessage(), e);
        return ErrorBuilder.newBuilder().message("Entity Not Found").error("missing_entity", e.getLocalizedMessage())
                .build(Response.Status.NOT_FOUND);
    }
}
