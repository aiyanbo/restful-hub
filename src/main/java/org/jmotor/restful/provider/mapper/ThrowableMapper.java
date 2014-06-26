package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.response.ErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(ThrowableMapper.class);

    @Override
    public Response toResponse(Throwable throwable) {
        LOGGER.error(throwable.getLocalizedMessage(), throwable);
        return ErrorBuilder.newBuilder()
                .message("Server has error.")
                .error("internal_server_error", throwable.getLocalizedMessage())
                .build(Response.Status.INTERNAL_SERVER_ERROR);
    }
}
