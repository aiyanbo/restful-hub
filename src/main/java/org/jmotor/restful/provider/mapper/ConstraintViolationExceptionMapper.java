package org.jmotor.restful.provider.mapper;

import org.jmotor.restful.response.ErrorBuilder;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Set;

/**
 * Component:
 * Description:
 * Date: 14-4-28
 *
 * @author Andy Ai
 */
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        ErrorBuilder builder = ErrorBuilder.newBuilder();
        builder.message("Illegal Parameter");
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        for (ConstraintViolation constraintViolation : constraintViolations) {
            String code = "illegal_parameter";
            if (NotNull.class.equals(constraintViolation.getConstraintDescriptor().getAnnotation().annotationType())) {
                code = "missing_parameter";
            }
            builder.error(code, constraintViolation.getMessage());
        }
        return builder.build(Response.Status.BAD_REQUEST);
    }
}
