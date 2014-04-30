package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.exception.AuthenticationException;
import org.jmotor.restful.response.Builder;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Component:
 * Description:
 * Date: 14-4-30
 *
 * @author Andy Ai
 */
public class AuthenticationExceptionMapper implements ExceptionMapper<AuthenticationException> {
    @Override
    public Response toResponse(AuthenticationException exception) {
        AuthenticationException.Code code = exception.code();
        return Builder.newBuilder().message(code.message())
                .error(code.code(), code.message()).build(code.status());
    }
}
